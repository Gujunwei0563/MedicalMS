package com.example.web138_project.controller;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.image.ImageModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.zhipu.ZhipuAiChatModel;
import dev.langchain4j.model.zhipu.ZhipuAiImageModel;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class AiController implements Initializable {
    public TextArea keyTextRef;
    public TextArea resultTextRef;
    public ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       javafx.scene.image.Image image = new javafx.scene.image.Image(this.getClass().getResourceAsStream("/images/bg5.jpg"));
        imageView.setImage(image);
        resultTextRef.setWrapText(true);
    }

    public void askHandel(ActionEvent actionEvent) {
        ChatLanguageModel chatModel = ZhipuAiChatModel.builder()
                .apiKey("ac28941f3e854c62a0cb39896af2f86a.G8h34QcwtxwrZGjo")
                .model("GLM-4")
                .build();

	  			String answer = chatModel.generate(keyTextRef.getText());
                   resultTextRef.setText(answer);
//		String answer = chatModel.generate("你好，现在中国北京最火的女明星是谁？");
//	  			System.out.println(answer);
    }

    public void createImageHandel(ActionEvent actionEvent) {
        ImageModel imageModel = ZhipuAiImageModel.builder()
                .apiKey("ac28941f3e854c62a0cb39896af2f86a.G8h34QcwtxwrZGjo")
                .build();
        Response<Image> response = imageModel.generate("小狗");
        System.out.println(response.content().url());
    }
}
