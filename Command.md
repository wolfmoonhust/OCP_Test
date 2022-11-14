install apk: adb install -r -d path

Prefix: adb shell am start -a android.intent.action.MAIN -n com.samsung.sec.android.application.csc/com.samsung.sec.android.application.preconfig.Preconfig

Reboot to set binary: adb reboot download

pull data: adb pull /data/data/com.sec.android.app.launcher D:\Data\
adb pull /product/omc/XTC/etc/default_workspace.xml D:\Data

push data: adb push D:\Data\default_workspace.xml /prism/etc/carriers/single/EUX

F/C app: adb shell am force-stop com.sec.android.app.launcher

Clear DB: adb shell pm clear com.sec.android.app.launcher

Change density: adb shell wm density 240

Get path: adb shell pm path com.sec.android.app.launcher

Log more info: adb shell "dumpsys package com.sec.android.app.launcher" > launcher.txt

Start launcher: adb shell am start -n com.sec.android.app.launcher/com.sec.android.app.launcher.activities.LauncherActivity
				adb shell am start -n com.samsung.android.dialer
				adb shell am start -a android.intent.action.MAIN -n com.samsung.android.app.homestar/com.samsung.android.app.homestar.home.HomeActivity
adb shell am start -a android.intent.action.MAIN -n com.samsung.android.app.homestar/com.samsung.android.app.homestar.SettingActivity
adb shell am start -a android.intent.action.MAIN -n com.sec.android.app.servicemodeapp/com.sec.android.app.servicemodeapp.SysDump
adb shell am start -n com.sec.android.app.servicemodeapp/com.sec.android.app.servicemodeapp.SysDump
				
git push origin HEAD:refs/for/develop/launcher3
git push origin HEAD:refs/for/develop/oneuihome3
git push origin HEAD:refs/for/develop/oneui5

Capture screen shot: adb shell screencap -p /sdcard/DCIM/screencap1.png

Recenly app: adb shell input keyevent KEYCODE_APP_SWITCH

Keycode event: https://stackoverflow.com/questions/7789826/adb-shell-input-events

Delete acc: adb shell dd if=/dev/zero of=/dev/block/persistent bs=1 count=512

Chage salecode *#243203855#

Update badge count in provider: android.intent.action.BADGE_COUNT_UPDATE & com.sec.intent.action.BADGE_COUNT_UPDATE

Memory dumpstate:
adb shell dumpsys meminfo
adb shell dumpsys meminfo PID

Fix Update_Incompatible:
adb shell pm path com.sec.android.app.launcher
adb root remount
adb root push [apk_path] [path]

//xoay doc/ngang value 0/1
adb shell content insert --uri content://settings/system --bind name:s:user_rotation --bind value:i:0

Ignore ssl: npm config set strict-ssl false -g

Error network connectivity: npm config set registry http://registry.npmjs.org/

python systrace.py -t 4 -a com.sec.android.app.launcher
python systrace.py --time=10 --no-compress -o trace.html sched gfx view -a com.sec.android.app.launcher
pip install --trusted-host pypi.org --trusted-host files.pythonhosted.org <package_name>

Config build gradle add to below:
configurations.all {
    resolutionStrategy.eachDependency {details ->
        def requested = details.requested
        if (requested.group == 'com.android.support') {

            details.useVersion '26.0.0-alpha1'

        }
    }
}

SHA-1 certificate fingerprint:
    93:45:35:AB:B1:6C:C3:39:BB:73:A4:2C:FC:17:AC:A4:75:9C:26:6A

Package HomeScreen: http://165.213.202.48/package/#/admin/projects/Package/Homescreen
Clone: ssh://son.nt1@165.213.202.48:2727/Package/Homescreen
GUI-line : Get database
1. Open Settings -> Apps -> More Button -:> Show System App. 
2. Open Samsung Experiecn Home -> Permission -> Enable Storage 
3. Open My file app -> Internal Storage -> More Button -> Settings -> Show hidden File 
4. In Myfile -> Download -> More Button -> Create Folder with name ".homedata" -> OK
5. In Home Screen Long Press on Home Sreen (or pinch zoom in) -> Long Press Widget -> pop up coppy complete .
6. Give us all folder ".homedata" in Myfile app

Home layout:
Create folder  /Download/.homescreen/
Save folder LCExtractor

ADD SS CERTIFICATE
git push: git push origin HEAD:refs/for/production/sep9.0

sudo keytool -importcert -alias samsungcert -file samsung.crt -keystore /usr/lib/jvm/java-8-oracle/jre/lib/security/cacerts -storepass changeit

sudo keytool -importcert -alias samsungcert -file samsung.crt -keystore /usr/lib/jvm/java-9-openjdk-amd64/lib/security/cacerts -storepass changeit

i.기본 경로 JRE : keytool -storepass changeit -import -file "samsung.crt" -keystore "C:\Program Files\Java\jre1.8.0_144\lib\security\cacerts" -alias samsungcert
ii.기본 경로 JDK : keytool -storepass changeit -import -file "samsung.crt" -keystore "C:\Program Files\Java\jdk1.8.0_144\jre\lib\security\cacerts" -alias samsungcert
iii.안드로이드 임베디드 경로 : keytool -storepass changeit -import -file "samsung.crt" -keystore "C:\Program Files\Android\Android Studio\jre\jre\lib\security\cacerts" -alias samsungcert

Issue was fixed on main branch, but this is market released model so launcher will be updated via store
However, in order to submit on Store, a version must be stable and to be verified on many models to avoid any side effect. This process will take more than several weeks
So if can, please kindly close it and transfer the issue to our app verification branch of PLM: 
02]19' Regular app update 
1) Dev. Type: Maintenance
2) Pjt. Stat: All
3) Item Status: All
4) Range: Maintenance Item. 
if you have any problem, please contact to me first, Thanks~

FIX INSTALL FAILED: settings>build,execute,deployment>instant run>Enable instant run to hot swap code /resource change on deploy(unchecked this option)


 Samsung account
 1. Flash ENG binary
 2. When device to Setup Wizard run some adb command
 adb remount
 adb shell
 #su -c setenforce 0
 #rm /system/priv-app/SetupWizard/SetupWizard.apk
 #rm /system/app/SecSetupWizard2013/SecSetupWizard2013.apk
 reboot
 3. After booting device, sign in other Samsung account and remove it

 Google account
 +  1. Flash ENG binary and reboot
    2. Connect device to PC for use adb command
    3. When device to Setup Wizard run adb command: 
         $adb shell dd if=/dev/zero of=/dev/block/persistent bs=1 count=512
    4. Reboot
change sale code 
adb shell am start -a android.intent.action.MAIN -n com.samsung.sec.android.application.csc/com.samsung.sec.android.application.preconfig.Preconfig


void save(Bitmap bm) {
	cnt++;
	// path to /data/data/yourapp/app_data/imageDir
	File directory = mContext.getDir("imageDir", Context.MODE_PRIVATE);
	// Create imageDir
	File mypath=new File(directory,cnt + "profile.jpg");

	FileOutputStream fos = null;
	try {
		fos = new FileOutputStream(mypath);
		// Use the compress method on the BitMap object to write image to the OutputStream
		bm.compress(Bitmap.CompressFormat.PNG, 100, fos);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}