#include <jni.h>

extern "C" JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_azizhudaya_learntktpl_MainActivity_sumNumbers(JNIEnv *env,
                                                                                 jobject thiz,
                                                                                 jint num1,
                                                                                 jint num2) {
    return num1 + num2;
}