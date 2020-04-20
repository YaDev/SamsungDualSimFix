package dev.yadev.samsungdualsimfix;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;


public class DualSimModule implements IXposedHookLoadPackage {
    public static final String targetClass = "com.android.server.StorageManagerService";
    public static final String targetMethod = "isSimSdBlock";
    public static final String targetPackageName = "android";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(lpparam != null) {
            if(lpparam.packageName != null) {
                if (lpparam.packageName.equals(targetPackageName)) {
                    XposedBridge.log("SamsungDualSimFix: Applying Dual Sim Cards and SD Card fix");
                    findAndHookMethod(targetClass, lpparam.classLoader, targetMethod, new XC_MethodReplacement() {
                        @Override
                        protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                            return null;
                        }
                    });
                }
            }
        }
    }
}

