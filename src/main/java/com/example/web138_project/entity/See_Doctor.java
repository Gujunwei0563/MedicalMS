package com.example.web138_project.entity;

public class See_Doctor {
        private int orderid;
        private int patieid;
        private int regid;
        private int deptid;
        private String descp;
        private String createtieme;
        private int docid;
        private double cash;
        private int pay;

        public See_Doctor(int orderid, int patieid, int regid, int deptid, String descp, String createtieme, int docid, double cash, int pay) {
            this.orderid = orderid;
            this.patieid = patieid;
            this.regid = regid;
            this.deptid = deptid;
            this.descp = descp;
            this.createtieme = createtieme;
            this.docid = docid;
            this.cash = cash;
            this.pay = pay;
        }

        public See_Doctor() {
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public int getPatieid() {
            return patieid;
        }

        public void setPatieid(int patieid) {
            this.patieid = patieid;
        }

        public int getRegid() {
            return regid;
        }

        public void setRegid(int regid) {
            this.regid = regid;
        }

        public int getDeptid() {
            return deptid;
        }

        public void setDeptid(int deptid) {
            this.deptid = deptid;
        }

        public String getDescp() {
            return descp;
        }

        public void setDescp(String descp) {
            this.descp = descp;
        }

        public String getCreatetieme() {
            return createtieme;
        }

        public void setCreatetieme(String createtieme) {
            this.createtieme = createtieme;
        }

        public int getDocid() {
            return docid;
        }

        public void setDocid(int docid) {
            this.docid = docid;
        }

        public double getCash() {
            return cash;
        }

        public void setCash(double cash) {
            this.cash = cash;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        @Override
        public String toString() {
            return "See_Doctor{" +
                    "orderid=" + orderid +
                    ", patieid=" + patieid +
                    ", regid=" + regid +
                    ", deptid=" + deptid +
                    ", descp='" + descp + '\'' +
                    ", createtieme='" + createtieme + '\'' +
                    ", docid=" + docid +
                    ", cash=" + cash +
                    ", pay=" + pay +
                    '}';
        }
}

