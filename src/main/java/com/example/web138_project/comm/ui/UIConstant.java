package com.example.web138_project.comm.ui;

public enum UIConstant {
    DOC_MANAGER(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/docmanager.fxml";
        }
    },
    DOC_ADD(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/docadd.fxml";
        }
    },
    PRESCRIBE(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/prescribe.fxml";
        }
    },
    PAT_ADD(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/patientadd.fxml";
        }
    },
    AI(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/ai.fxml";
        }
    },
    PAT_MANAGER(LoadType.LAZY){
        @Override
        public String toString() {
            return"/com/example/web138_project/patientmanager.fxml";
        }
    },
    Med_TYPE(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/medicinetype.fxml";
        }
    },
    Med_ADD(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/medicineadd.fxml";
        }
    },
    Med_MANAGER(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/medicinemanager.fxml";
        }
    },
    DOC_VIEW(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/doctorview.fxml";
        }
    },
    ADMIN_ADD(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/adminadd.fxml";
        }
    },
    REGISTRATION(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/registration.fxml";
        }
    },
    SEE_DOC(LoadType.LAZY){
        @Override
        public String toString() {
            return "/com/example/web138_project/seedoctor.fxml";
        }
    };
    public LoadType getLoadType() {
        return loadType;
    }

    public void setLoadType(LoadType loadType) {
        this.loadType = loadType;
    }

    private LoadType loadType;
   private UIConstant(LoadType loadType){
        this.loadType=loadType;
    }

}
