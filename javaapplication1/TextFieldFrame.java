package javaapplication1;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame {
    private JTextField textField1; // campo de texto com tamanho configurado
    private JTextField textField2; // campo de texto contruído com texto
    private JTextField textField3; // campo de texto com texto e tamanho
    private JPasswordField passwordField; // campo de senha com texto
    
    // contrutor TextFieldFrame adiciona JTextFields a JFrame
    public TextFieldFrame() {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout()); // configura o layourt de frame
        
        //constrói textfield com 10 colunas;
        textField1 = new JTextField(10); // A largura da um JTextFild é baseada na fonte atual do componente a menos que o gerenciador de layout sobrescreva esse tamanho.
        add(textField1); // adiciona textField1 ao JFrame
        
        // constrói campo de texto com texto padrão
        textField2 = new JTextField("Enter text here"); // A largura de um JTextField ~e baseada no texto padrão a menos que o gerenciador de layout sobrescreva esse tamanho
        add(textField2); // adiciona textField2 ao JFrame
        
        // contrói textfield com o texto padrão e 21 colunas
        textField3 = new JTextField("Uneditable text field", 21); // largura baseada no segundo argumento a menos que o gerenciador de layourt sobrescreva esse tamanho
        textField3.setEditable(false); // desativa a edição
        add(textField3); // adiciona textField3 ao JFrame
        
        // constrói passwordfield com o texto padrão
        passwordField = new JPasswordField("Hidden text"); // o testo nesse componente será oculto por asteriscos por padrão
        add(passwordField); // adiciona passwordField ao JFrame
        
        // handlers de evento registradores
        TextFieldHandler handler = new TextFieldHandler(); // a classe interna TextFieldHandler implementa a interface ActionListener para que ela possa responder a eventos JTextField. As linhas 41-44 registram o objeto handler para responder aos eventos de cada componente.
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        passwordField.addActionListener(handler);  
    } //fim do construtor TextFieldFrame
    
    // classe interna private para tratamento de evento
    private class TextFieldHandler implements ActionListener{ // um TextFieldHandle é um ActionListener
        
        //processa eventos de campo de texto
        public void actionPerformed(ActionEvent event){ // chamado qundo o usuário pressiona Enter em um JTextField ou JPasswordField
            String string = ""; // declara a string a ser exigida
            
            //usuário pressionou Enter no JTextField textField1
            if (event.getSource() == textField1)
                string = String.format("textField1: %s", 
                        event.getActionCommand());
            
            //usuário pressionou Enter no JTextField textField2
            else if (event.getSource() == textField2)
                string = String.format("textField2: %s", 
                        event.getActionCommand());
            
            //usuário pressionou Enter no JTextField textField3
            else if (event.getSource() == textField3)
                string = String.format("textField3: %s", 
                        event.getActionCommand());
            
            //usuário pressionou Enter no JTextField passwordField
            else if (event.getSource() == passwordField)
                string = String.format("passwordField: %s", 
                        event.getActionCommand());
            
            //exibe o conteúdo de JTextField
            JOptionPane.showMessageDialog(null, string);
        } // fim do método actionPerformed
    } // fim da classe TextFieldHandler interna private
} //fim da classe TextFielFrame
