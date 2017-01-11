package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TastBase {

    @Test
    public void testGroupDeletion () {
        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectGroups();
        app.returnToGroupPage();

    }

}
