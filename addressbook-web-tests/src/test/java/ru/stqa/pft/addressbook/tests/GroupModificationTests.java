package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by jekko on 12.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().List().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().List();
    int index = before.size() -1;
    GroupData group = new GroupData()
            .withId(before.get(index).getId()).withName("test1").withFooter("test2").withHeader("test3");
    app.group().modify(index, group);
    List<GroupData> after = app.group().List();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    after.sort(byId);
    before.sort(byId);
    Assert.assertEquals(before, after);
  }
}
