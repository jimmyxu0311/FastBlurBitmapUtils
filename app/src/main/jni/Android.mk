LOCAL_PATH		:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := fast-blur
LOCAL_SRC_FILES := stackblur.c FastBlur.c load.c
LOCAL_LDLIBS    := -lm -llog -ljnigraphics

include $(BUILD_SHARED_LIBRARY)