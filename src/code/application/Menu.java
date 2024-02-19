//Programa creado por José Alejandro Briones Arroyo, Jesús Antonio Estrada Jiménez, Luis Octavio López Martínez, Eli Haziel Ortiz Ramírez y Jaime Vazquez Santiago.
package code.application;

import javax.swing.*;//Swing es una biblioteca gráfica para Java. Incluye widgets para interfaz gráfica de usuario tales como cajas de texto, botones, listas desplegables y tablas.
import java.awt.*;//AWT es una interfaz Java para el código GUI del sistema nativo presente en su sistema operativo. No funcionará igual en todos los sistemas, aunque lo intenta.
import java.awt.event.*;//Proporciona interfaces y clases para manejar diferentes tipos de eventos activados por componentes AWT.

public class Menu extends JFrame implements ActionListener{
    JButton rules, back;//Creación de botones.
    JTextField tfname;//Es un componente de poco peso que permite la edición de una sola línea de texto.
    
    Menu() {
        getContentPane().setBackground((new Color(236, 173, 219)));//Obtiene el contenido y asigna el color como fondo este mismo.
        setLayout(null);//Coloca la disposición.

        //Se carga la imagen
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/tigre1.png"));
        //Se obtiene la imagen del ImageIcon
        Image img1 = i2.getImage();
        //Se redimensiona la imagen
        Image newImg2 = img1.getScaledInstance(325, 315, java.awt.Image.SCALE_SMOOTH);
        //Se crea un nuevo ImageIcon con la imagen redimensionada
        ImageIcon newIcon2 = new ImageIcon(newImg2);
        //Se crea una etiqueta de texto asociada al objeto ImageIcon
        JLabel image2 = new JLabel(newIcon2);
        //Se modifica la posición y las dimensiones de la imagen
        image2.setBounds(140, 20, 300, 290);
        //Se añade el componente especificado al final de este contenedor
        add(image2);

        JLabel heading = new JLabel("CUESTIONARIO DEL AMOR");//Se utiliza para crear una pequeña etiqueta de texto asociada al objeto.
        heading.setBounds(600, 100, 1450, 100);//SE UTILIZA PARA ESTABLECER EL TAMAÑO Y LA POSICION EN UNA VENTANA O CONTENEDOR
        heading.setFont(new Font("Palatino Linotype", Font.BOLD, 55));//ESTABLECIENDO LA FUENTE Y EL TAMAÑO
        heading.setForeground(new Color(55, 42, 68));//Modifica el color de la etiqueta de texto utilizando el modelo RGB.
        add(heading);//Se utiliza para agregar un componente a un contenedor.
        
        //Se carga la imagen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/utxj.png"));
        //Se obtiene la imagen del ImageIcon
        Image img = i1.getImage();
        //Se redimensiona la imagen
        Image newImg = img.getScaledInstance(520, 581, java.awt.Image.SCALE_SMOOTH);
        //Se crea un nuevo ImageIcon con la imagen redimensionada
        ImageIcon newIcon = new ImageIcon(newImg);
        //Se crea una etiqueta de texto asociada al objeto ImageIcon
        JLabel image = new JLabel(newIcon);
        //Se modifica la posición y las dimensiones de la imagen
        image.setBounds(10, 200, 520, 581);
        //Se añade el componente especificado al final de este contenedor
        add(image);

        JLabel name = new JLabel("Ingresa tu nombre:");//Se utiliza para crear una pequeña etiqueta de texto.
        name.setBounds(800, 255, 1450, 100);//Modifica la posición y las dimensiones de la etiqueta de texto.
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 50));//Modifica las propiedades de la etiqueta de texto como tipografía y tamaño.
        name.setForeground(new Color(74, 57, 89));//Modifica el color de la etiqueta de texto utilizando el modelo RGB.
        add(name);//Se utiliza para agregar un componente a un contenedor.
        
        tfname = new JTextField();//Se utiliza para crear un cuadro de texto en una GUI.
        tfname.setBounds(760, 400, 510, 60);//Modifica la posición y las dimensiones del cuadro de texto.
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 30));//Modifica las propiedades del cuadro de texto como tipografía y tamaño.
        add(tfname);//Se utiliza para agregar un componente a un contenedor.
        
        back = new JButton("SALIR");//CREACION Y ASIGNACION DE MEDIDADAS DEL BOTTON PARA REGRESAR
        back.setFont(new Font("Josefin Sans", Font.BOLD, 18));//EN ESTA LINEA AGREGAMOS EL TIPO DE FUENTE JUNTO CON SU PROPIEDAD DE ESTAR EN "NEGRITAS" Y EL TAMANIO DE FUENTE
        back.setBounds(800, 650, 170, 70);//EN ESTA LINEA LO QUE HACEMOS ES ACOMODAR LAS POSICIONES Y EL TAMANIO DEL BOTON
        back.setBackground(new Color(74, 57, 89));//EN ESTA LINEA LE AGREGAMOS UN NUEVO COLO AL BOTON
        back.setForeground(Color.WHITE);//ACA AGREGAMOS EL COLOR DE LA FUENTE
        back.addActionListener(this);//SE UTILIZA PARA ASIGNAR UN ActionListener A UN COMPONENTE, EN ESTE CASO UN BOTON
        add(back);//AÑADIMO EL BOTON DE REGRESO A LA INTERFAZ
        
        rules = new JButton("COMENZAR");//CREACION Y ASIGNACION DE MEDIDADAS DEL BOTON PARA COMENZAR EL TEST 
        rules.setFont(new Font("Josefin Sans", Font.BOLD, 18));
        rules.setBounds(1070, 650, 170, 70);
        rules.setBackground(new Color(194, 53, 77));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);//AÑADIMOS EL BOTON DE INICIAR A LA INTERFAZ
        
        setSize(1450, 850);//Modifica las dimensiones de la ventana.
        //Se calcula mediante operaciones la posicion en el eje X y Y de la pantalla para colocar la ventana en el centro de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth()/2;
        int centerY = (int) screenSize.getHeight()/2;
        setLocation(centerX - getWidth()/2, centerY - getHeight()/2);//Modifica la posición de la ventana.
        setVisible(true);//Modifica el estado de la visibilidad de la ventana.
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rules) {
            String name = tfname.getText();
            setVisible(false);//Modifica el estado de la visibilidad.
            new Rules(name);//Crea una nueva instancia de una clase.
        } else if (ae.getSource() == back) {
            setVisible(false);//Modifica el estado de la visibilidad.
        }
    }
    
    public static void main(String[] args) {
        new Menu();//Crea una nueva instancia de una clase.
    }
}