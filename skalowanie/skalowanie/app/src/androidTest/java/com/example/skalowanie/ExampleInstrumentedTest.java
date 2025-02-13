<<<<<<<< HEAD:formularzeOsobowe/app/src/androidTest/java/com/example/formularzeosobowe/ExampleInstrumentedTest.java
package com.example.formularzeosobowe;
========
package com.example.skalowanie;
>>>>>>>> 253bc368b798855b0f91d425224f01dd461fd791:skalowanie/skalowanie/app/src/androidTest/java/com/example/skalowanie/ExampleInstrumentedTest.java

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
<<<<<<<< HEAD:formularzeOsobowe/app/src/androidTest/java/com/example/formularzeosobowe/ExampleInstrumentedTest.java
        assertEquals("com.example.formularzeosobowe", appContext.getPackageName());
========
        assertEquals("com.example.skalowanie", appContext.getPackageName());
>>>>>>>> 253bc368b798855b0f91d425224f01dd461fd791:skalowanie/skalowanie/app/src/androidTest/java/com/example/skalowanie/ExampleInstrumentedTest.java
    }
}