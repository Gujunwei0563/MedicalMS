package com.example.web138_project.comm.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyUIManager {
    static Map<UIConstant, Object> nodeMap =new HashMap<>();
    public static void  initView(){
        UIConstant[] values =UIConstant.values();
        for (UIConstant u:values){
            String url =u.toString();
            System.out.println(url);
            if (u.getLoadType()==LoadType.EAGER){
                try {
                    Parent root = FXMLLoader.load(MyUIManager.class.getResource(url));
                    nodeMap.put(u,root);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else {
                nodeMap.put(u,url);
            }
        }
    }
    public static void show(ObservableList<Node> nodeList ,UIConstant uiConstant ) {
        nodeList.clear();
        Node node =null;
        if (uiConstant.getLoadType()==LoadType.EAGER){
            node =(Node)nodeMap.get(uiConstant);
        }else {
            String  viewUrl = (String)nodeMap.get(uiConstant);
            try {
                node =FXMLLoader.load(MyUIManager.class.getResource(viewUrl));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        nodeList.add(node);
    }

}
