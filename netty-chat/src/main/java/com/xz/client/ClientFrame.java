package com.xz.client;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.xz.client
 * @ClassName: ClientFarme
 * @Author: xz
 * @Date: 2020/7/2 13:36
 * @Version: 1.0
 */
public class ClientFrame extends Frame {

    public static final ClientFrame INSTANCE = new ClientFrame();

    private TextField textField;

    private TextArea textArea;

    private ChatClient chatClient;

    public ClientFrame() throws HeadlessException {
        setLocation(200,300);
        setSize(400,300);
        textField = new TextField();
        textField.addActionListener(e -> {
            textArea.setText(textArea.getText()+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +" "+ textField.getText()+"\r\n");
            chatClient.send(textField.getText());
            textField.setText("");
        });
        textArea = new TextArea();
        textArea.setBackground(Color.GRAY);
        Font font = new Font("宋体", Font.BOLD, 15);
        textArea.setFont(font);
        setTitle("聊天室");
        add(textArea, BorderLayout.CENTER);
        add(textField,BorderLayout.SOUTH);
        chatClient = new ChatClient();
        setVisible(true);
        new Thread(()->chatClient.connect()).start();
    }

    public TextArea getTextArea() {
        return textArea;
    }
}
