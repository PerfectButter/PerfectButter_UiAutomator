PerfectButter_UiAutomator
=========================

Clone Repo:
<p>$ git clone git@github.com:PerfectButter/PerfectButter_UiAutomator.git

Building and Deploying UiAutomator Test
<p>$ <android-sdk>/tools/android create uitest-project -n PerfectButterTest -t 24 -p <path>/PerfectButter_UiAutomator
<p><b>example: $ ~/Development/android/tools create uitest-project -n PerfectButterTest -t 24 /Volumes/android/PerfectButter_UiAutomator</b>

<p>$ ant build

<p>$ adb push <path_to_output_jar> /data/local/tmp/
<p><b>example: $ adb push /Volumes/android/PerfectButter_UiAutomator/bin/PerfectButterTest.jar /data/local/tmp</b>

<p>Running UiAutomator Test
<p>$ adb shell uiautomator runtest PerfectButterTest.jar -c com.perfectbutter.uiautomator.UiTester
