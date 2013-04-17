PerfectButter_UiAutomator
=========================

Clone Repo:
$ git clone git@github.com:PerfectButter/PerfectButter_UiAutomator.git

Building and Deploying UiAutomator Test
$ <android-sdk>/tools/android create uitest-project -n PerfectButterTest -t 24 -p <path>/PerfectButter_UiAutomator
	example: $ ~/Development/android/tools create uitest-project -n PerfectButterTest -t 24 /Volumes/android/PerfectButter_UiAutomator

$ ant build

$ adb push <path_to_output_jar> /data/local/tmp/
	example: $ adb push /Volumes/android/PerfectButter_UiAutomator/bin/PerfectButterTest.jar /data/local/tmp

Running UiAutomator Test
$ adb shell uiautomator runtest PerfectButterTest.jar -c com.perfectbutter.uiautomator.UiTester