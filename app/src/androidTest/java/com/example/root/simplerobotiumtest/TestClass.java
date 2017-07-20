package com.example.root.simplerobotiumtest;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.root.simplerobotiumtest.activity.LoginActivity;
import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by root on 20/7/17.
 */

@RunWith(AndroidJUnit4.class)
public class TestClass {

    private static final String EMAIL = "admin@gmail.com";
    private static final String PWD = "admin";


    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);

    private Solo solo;


    @Before
    public void setUp() throws Exception {
        //setUp() is run before a test case is started.
        //This is where the solo object is created.
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    @Test
    public void testLoginButton() throws Exception {
        //Unlock the lock screen
        solo.unlockScreen();
       /* solo .getView(R.id.edt_login_email).solo.getEditText(EMAIL);*/
        //Click on action menu item add
        solo.clickOnView(solo.getView(R.id.btn_login));
        //Assert that NoteEditor activity is opened
        solo.assertCurrentActivity("Expected LoginActivity", LoginActivity.class);
        //In text field 0, enter Note 1
//        solo.enterText(0, NOTE_1);
     /*   //Click on action menu item Save
        solo.clickOnView(solo.getView(com.example.android.notepad.R.id.menu_save));
        //Click on action menu item Add
        solo.clickOnView(solo.getView(com.example.android.notepad.R.id.menu_add));
        //In text field 0, type Note 2
        solo.typeText(0, NOTE_2);
        //Click on action menu item Save
        solo.clickOnView(solo.getView(com.example.android.notepad.R.id.menu_save));
        //Takes a screenshot and saves it in "/sdcard/Robotium-Screenshots/".
        solo.takeScreenshot();
        //Search for Note 1 and Note 2
        boolean notesFound = solo.searchText(NOTE_1) && solo.searchText(NOTE_2);
        //To clean up after the test case
        deleteNotes();*/
        //Assert that Note 1 & Note 2 are found
//        assertTrue("Note 1 and/or Note 2 are not found", notesFound);
    }

    @Test
    public void testEditNoteTitle() throws Exception {

    }

    private void deleteNotes() {

    }
}