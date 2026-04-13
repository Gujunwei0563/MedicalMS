package com.example.web138_project.comm.util;

public class ChangeTitle {
    private static boolean isEditMode =false;
    public static void setEditMode(boolean editMode) {
        isEditMode = editMode;
    }
    public static boolean isEditMode() {
        return isEditMode;
    }
}
