//Programa creado por José Alejandro Briones Arroyo, Jesús Antonio Estrada Jiménez, Luis Octavio López Martínez, Eli Haziel Ortiz Ramírez y Jaime Vazquez Santiago.
package code.application;//Esta linea define el paqeute en el ques e encutra la clase Score

import java.awt.*;//Proporciona las clases y metodos necesarios para crear y manipular graficas y componentes de la interfaz
import javax.swing.*;//Es una bibloteca que proporciona componentes de interfaz de usuario
import java.awt.event.*;//Contiene interfaces y clases para el manejo de eventos de la interfaz grafica 

public class Score extends JFrame implements ActionListener { 
    //Creacion del panel 
    Score(String name, int score) {
        setBounds(400, 150, 750, 550);//El metodo setBounds establece la posición y el tamaño de la ventana (interfaz gráfica)
        getContentPane().setBackground((new Color(236, 173, 219)));//Obtiene el contenido y asigna el color como fondo este mismo. //Este metodo establece el color de fondo de la ventana
        setLayout(null);//En este metodo establece el diseño de la ventana 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/tigre2.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 220, 800, 300);
        add(image);
        
        JLabel heading = new JLabel("¡Gracias " + name + " por responder este Test!");//Crea un nuevo objeto llamado JLabel, donde se mostrara un mensaje al usuario con su nombre, en este caso se mostrara su nombre en la variable "nombre" ingresada desde la clase Login
        heading.setBounds(130, 50, 1450, 100);//SE UTILIZA PARA ESTABLECER EL TAMAÑO Y LA POSICION EN UNA VENTANA O CONTENEDOR
        heading.setFont(new Font("Palatino Linotype", Font.BOLD, 50));//ESTABLECIENDO LA FUENTE Y EL TAMAÑO
        heading.setForeground(new Color(55, 42, 68));
        
        add(heading);//Agrega el objeto JLabel a la ventana principal de la interfaz
        
        JLabel lblscore = new JLabel("Probabilidad de que encuentre al amor de su vida: " + score+" %");//Crea un nuevo objeto con un mensaje donde se mostrara el puntaje de las respuestas contestadas 
        lblscore.setBounds(100, 600, 1400, 100);//Este metodo estable la poscicoon y el tamaño del objeto JLabel, donde igual se pocicionara en las cordenas x y y, de igual forma se pondra un anchura y una altura
        lblscore.setFont(new Font("Palatino Linotype", Font.PLAIN, 50));//Establece la fuente del texto 
        add(lblscore);
        
        JButton submit = new JButton("REGRESAR AL MENÚ");
        submit.setFont(new Font("Josefin Sans", Font.BOLD, 30));//EN ESTA LINEA AGREGAMOS EL TIPO DE FUENTE JUNTO CON SU PROPIEDAD DE ESTAR EN "NEGRITAS" Y EL TAMANIO DE FUENTE
        submit.setBounds(400, 700, 600, 100);//EN ESTA LINEA LO QUE HACEMOS ES ACOMODAR LAS POSICIONES Y EL TAMANIO DEL BOTON
        submit.setBackground(new Color(74, 57, 89));//EN ESTA LINEA LE AGREGAMOS UN NUEVO COLO AL BOTON
        submit.setForeground(Color.WHITE);//ACA AGREGAMOS EL COLOR DE LA FUENTE
        submit.addActionListener(this);//SE UTILIZA PARA ASIGNAR UN ActionListener A UN COMPONENTE, EN ESTE CASO UN BOTON
        add(submit);//AÑADIMO EL BOTON DE REGRESO A LA INTERFAZ
        
        setSize(1450, 850);//Modifica las dimensiones de la ventana.
        //Se calcula la posicion X y Y de la pantalla para colocar la ventana en el centro de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth()/2;
        int centerY = (int) screenSize.getHeight()/2;
        setLocation(centerX - getWidth()/2, centerY - getHeight()/2);//Modifica la posición de la ventana.
        setVisible(true);//Modifica el estado de la visibilidad de la ventana.
    }
    
    public void actionPerformed(ActionEvent ae) {//Este es el metodo que se llama automaticamente cuando se realiza una accion en la interfaz gráfica
        setVisible(false);//Este metodo se utiliza para ocultar la ventana actual, cuando se hace clic en el botn la ventana actual de Score se oculta
        new Menu();//Crea una nueva instancia de la clade Login
    }

    public static void main(String[] args) {//Este es el punto de entrada de la interfaz   
        new Score("User", 0);//Crea una nueva instancia de la clase Score 
    }
}