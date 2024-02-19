//Programa creado por José Alejandro Briones Arroyo, Jesús Antonio Estrada Jiménez, Luis Octavio López Martínez, Eli Haziel Ortiz Ramírez y Jaime Vazquez Santiago.
package code.application;

import javax.swing.*;//LIBRERIA QUE PROPORRCIONA CLASES Y COMPONENTES PARA LA CREACION DE INTERFACES
import java.awt.*;//CONUNTO DE CLASES QUE PERMITEN CREAR INTERFACES GRAFICAS PARA EL USUARIO(VENTANAS, BOTONES, CUADROS DE TEXTO)
import java.awt.event.*;//PERMITE UTILIZAR LAS CLASES E INTERFACES DEFINIDAS EN EL PAQUETE DE EVENTOS EN LA GUI de Java.

public class Rules extends JFrame implements ActionListener{//CREACION DE LA CLASE ("RULES") CON HERENCIA DEL JFRAME
    Font font = new Font("Arial", Font.BOLD, 12);
    String name;//CREACION DE LA VARIABLE PARA EL NOMBRE DEL USUARIO
    JButton start, back;//CREACION DE LOS BOTONES PARA EL INICIO Y RETROCESO
    
    Rules(String name) {

        this.name = name;
        getContentPane().setBackground((new Color(236, 173, 219))); //SE UTILIZA PARA OBTENER EL PANEL PRINCIPAL DE UN CONTENDEOR O VENTANA. 
        //SE UTILIZA PARA ESTABLECER EL COLOR DE FONDO DEL PANEL PRINCIPAL DE UN CONTENDER O VENTANA EN BLANCO. 
        setLayout(null);
        
        JLabel heading = new JLabel("Bienvenido " + name + " al Cuestionario del Amor");
        heading.setBounds(150, 50, 1450, 100);//SE UTILIZA PARA ESTABLECER EL TAMAÑO Y LA POSICION EN UNA VENTANA O CONTENEDOR
        heading.setFont(new Font("Palatino Linotype", Font.BOLD, 50));//ESTABLECIENDO LA FUENTE Y EL TAMAÑO
        heading.setForeground(new Color(55, 42, 68));
        add(heading);//SE UTILIZA PARA AGREGAR UN COMPONENTE DE LA INTERFAZ GRAFICA DE USUARIO (GUI) A UN CONTENEDOR. 
        
        JLabel rules = new JLabel();
        rules.setBounds(210, 50, 1000, 700);
        rules.setBackground(new Color(194, 53, 77));
        rules.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
        rules.setText( //EL METODO setText() ES UN METODO QUE SE UTILIZA EN LA CLASE JLabel DE Java PARA ESTABLECER EL TEXTO DE UNA ETIQUETA. 
            "<html>"+ 
                "<div style='text-align: justify'>" +
                "Este cuestionario que consta de 10 preguntas, ha sido diseñado para evaluar las probabilidades que tiene de conseguir una pareja en base a su personalidad." + "<br><br>" +
                "Este cuestionario ha sido previamente avalado y certificado por el piscólogo Alex Marin." + "<br><br>" +
                "Lea cuidadosamente cada pregunta antes de responder y asegúrese de seleccionar la opción que usted considere adecuada a su ser ;)"+
                "</div>"+
                "<html>"
        );
        //SE PUEDE UTILIZAR HTML EN LA GUI DE JAVA ES PORQUE Java UTILIZA LA BIBLIOTECA DE RENDERIZADO DE TEXTO LLAMADA javax.swing.text.html.HTML QUE PUEDE INTERPRETAR Y MOSTRAR ETIQUETAS HTML EN COMPOMENTES DE LA GUI.

        add(rules);
        
        back = new JButton("ATRÁS");//CREACION Y ASIGNACION DE MEDIDADAS DEL BOTTON PARA REGRESAR
        back.setFont(new Font("Josefin Sans", Font.BOLD, 18));//EN ESTA LINEA AGREGAMOS EL TIPO DE FUENTE JUNTO CON SU PROPIEDAD DE ESTAR EN "NEGRITAS" Y EL TAMANIO DE FUENTE
        back.setBounds(500, 700, 170, 70);//EN ESTA LINEA LO QUE HACEMOS ES ACOMODAR LAS POSICIONES Y EL TAMANIO DEL BOTON
        back.setBackground(new Color(74, 57, 89));//EN ESTA LINEA LE AGREGAMOS UN NUEVO COLO AL BOTON
        back.setForeground(Color.WHITE);//ACA AGREGAMOS EL COLOR DE LA FUENTE
        back.addActionListener(this);//SE UTILIZA PARA ASIGNAR UN ActionListener A UN COMPONENTE, EN ESTE CASO UN BOTON
        add(back);//AÑADIMO EL BOTON DE REGRESO A LA INTERFAZ
        
        start = new JButton("COMENZAR");//CREACION Y ASIGNACION DE MEDIDADAS DEL BOTON PARA COMENZAR EL TEST 
        start.setFont(new Font("Josefin Sans", Font.BOLD, 18));
        start.setBounds(750, 700, 170, 70);
        start.setBackground(new Color(194, 53, 77));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);//AÑADIMO EL BOTON DE INICIAR A LA INTERFAZ
        
        setSize(1450, 850);//MEDIANTE LOS set ASIGNAR LAS MEDIDAS 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //OBTIENE EL TAMANIO DE LA PANTALLA DEL DISPOSITIVO DONDE SE ESTA EJECUTANDO LA APLICACION MEDIANTE EL USO DE LA CLASE Toolkit DE JAVA. 
        int centerX = (int) screenSize.getWidth() / 2;//ESTA LINEA DE CODIGO OBTIENE EL CENTRO ORIZONTAL DE LA PANTALLA DIVIDIENDO EL ANCHO DE LA PANTALLA POR 2 Y CONVIRTIENDO EL RESULTADO EN UN ENTERO. 
        int centerY = (int) screenSize.getHeight() / 2;//ESTA LINEA DE CODIGO OBTIENE EL CENTRO VERTICAL DE LA PANTALLA DIVIDIENDO EL ANCHO DE LA PANTALLA POR 2 Y CONVIRTIENDO EL RESULTADO EN UN ENTERO. 
        setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);//ACA SE ESTABLECE LA HUBICACION DE LA VENTANA EN EL CENTRO DE LA PANTALLA.
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {//CONDICIONAL PARA QUE CUANDO SE HAGA CLICK EN EL BOTON "start" SE HAGA LA COMPARACION SI ES QUE ES IGUAL A LA VARIABLE PARA INICIAR
        if (ae.getSource() == start) {//CUANDO SE LE DE CLICK AL BOTON DE INICIAR SE VA A OCULTAR LA PANTALLA Y SE CREARA EL OBJETO QUE CONTIENE EL CUESTIONARIO COMO TAL.
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);//DE LO CONTRARIO SE OCULTARA LA PANTALLA Y SE CREARA EL OBJETO QUE CONTIENE EL LOGIN 
            new Menu();
        }
    }
    
    public static void main(String[] args) {//SE CREA LA CLASE PRINCIPAL
        new Rules("User");//SE AÑADA EL NOMBRE 
    }
}