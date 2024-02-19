//Programa creado por José Alejandro Briones Arroyo, Jesús Antonio Estrada Jiménez, Luis Octavio López Martínez, Eli Haziel Ortiz Ramírez y Jaime Vazquez Santiago.
package code.application;

import javax.swing.*;//Swing es una biblioteca gráfica para Java. Incluye widgets para interfaz gráfica de usuario tales como cajas de texto, botones, listas desplegables y tablas.
import java.awt.*;//AWT es una interfaz Java para el código GUI del sistema nativo presente en su sistema operativo. No funcionará igual en todos los sistemas, aunque lo intenta.
import java.awt.event.*;//Proporciona interfaces y clases para manejar diferentes tipos de eventos activados por componentes AWT.

public class Quiz extends JFrame implements ActionListener 
{
    String questions[][] = new String[10][5];//Array que guarda las preguntas y sus respectivos incisos 
    String useranswers[][] = new String[10][1];//Array que guarda las respuestas introducidas por el usuario
    JLabel qno, question;//Un area del display con un corto texto, una imagen o ambas, y no reacciona para a los eventos
    JRadioButton opt1, opt2, opt3, opt4;//JRadioButton Implementa un radio button, usado con ButtonGroup para crear un grupo de botones pero solo uno puede ser seleccionado, se crearon cuatro radioButtons.
    ButtonGroup groupoptions;//Clase que implementa un grupo de botones, en este caso el conjunto de botones se llama groupoptions
    JButton next, submit;//La clase JButton tiene una etiqueta y genera un evento cuando es presionado, también puede tener una imagen
    
    //El modificador "public" indica que la variable en cuestión es accesible desde cualquier lugar dentro del programa
    //El modificador "static" indica que la variable pertenece a la clase en lugar de a una instancia específica de la clase.
    //Significa que todos los objetos creados a partir de esta clase compartirán la misma variable.
    
    public static int timer = 15;//Declara una variable llamada "timer" que es pública, estática y de tipo entero (int).
    public static int ans_given = 0;//Se declara e inicializa la variable ans_given
    public static int count = 0;//Se declara e inicializa la variable count
    public static int score = 0;//Se declara e inicializa la variable score
    
    String name;//Se declara la variable name

    Quiz(String name)//La definición del constructor de una clase "Quiz" que toma un parámetro de tipo String llamado "name" que se utiliza para inicializar algunos de los atributos de la clase.
    {
        timer = 15;//Reinicia la variable timer.
        ans_given = 0;//Reinicia la variable ans_given.
        count = 0;//Reinicia la variable count.
        score = 0;//Reinicia la variable score.
        
        this.name = name;//Se refiere al atributo "name" de la instancia actual de la clase, hacer referencia al atributo "name" de la instancia actual de la clase "Quiz", y "name" para hacer referencia al parámetro que se pasa al constructo 
        setBounds(50, 0, 1440, 850);//Para definir el alto, el ancho y su posición en el plano partesiano
        getContentPane().setBackground(Color.PINK); 
        //getContentPane() Recupera la capa del panel de contenido para que pueda agregarle un objeto. El panel de contenido es un objeto creado por el entorno de tiempo de ejecución de Java.
        //.setBackground() Asigna un color al background de un componente
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/banner.jpg"));//Permite cargar una imagen de manera local.
        JLabel image = new JLabel(i1);//Crea un área para la imagen.
        image.setBounds(0, 0, 1440, 392);//Modifica la posición dentro del eje X y Y, así cómo también las dimensiones de la imagen.
        add(image);//Se añade el componente especificado al final de este contenedor.
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 80);
        qno.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
        add(qno);//Se añade el componente especificado al final de este contenedor.
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 80);
        question.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
        add(question);//Se añade el componente especificado al final de este contenedor.
        //Creación y almacenamiento de las preguntas junto con sus respuestas en un arreglo bidimensional.
        questions[0][0] = "Del 1 al 10, ¿Qué calificación te das cómo persona?";
        questions[0][1] = "Entre 0-2.";
        questions[0][2] = "Entre 3-5.";
        questions[0][3] = "Entre 6-7.";
        questions[0][4] = "Entre 8-10.";

        questions[1][0] = "¿Consideras que eres buen conversador?";
        questions[1][1] = "Soy una persona muy platicadora.";
        questions[1][2] = "Se mantener una charla.";
        questions[1][3] = "¿Charlar?, yo prefiero mandar mensajes de texto.";
        questions[1][4] = "No, no soy bueno en eso.";

        questions[2][0] = "¿Te gusta salir de fiesta?";
        questions[2][1] = "Sí, me gusta estar de callejer@.";
        questions[2][2] = "Me divierto estando afuera pero prefiero hacerlo de otras maneras.";
        questions[2][3] = "Me es indiferente.";
        questions[2][4] = "No, prefiero estar en casa.";

        questions[3][0] = "¿Te consideras una persona romántica?";
        questions[3][1] = "Sí, me llaman Romeo.";
        questions[3][2] = "Ni mucho, ni poco";
        questions[3][3] = "Depende la persona y el lugar.";
        questions[3][4] = "No, fuchi.";

        questions[4][0] = "¿Qué es lo que más te llama la atención de una persona?";
        questions[4][1] = "Su personalidad.";
        questions[4][2] = "Su físico.";
        questions[4][3] = "50% físico y 50% personalidad.";
        questions[4][4] = "Su situación económica.";

        questions[5][0] = "¿Cómo sería la personalidad de tu pareja ideal?";
        questions[5][1] = "Alegre y divertida.";
        questions[5][2] = "Respetuosa y empática.";
        questions[5][3] = "Ambiciosa y decidida.";
        questions[5][4] = "Ninguna, las expectativas son de personas inmaduras.";

        questions[6][0] = "¿Te has planteado usar alguna app de citas para encontrar pareja?";
        questions[6][1] = "Sí, soy un experto.";
        questions[6][2] = "Quizás.";
        questions[6][3] = "Prefiero conocer a las personas en la vida real.";
        questions[6][4] = "No, no me interesa.";

        questions[7][0] = "¿Qué has aprendido del amor hasta ahora?";
        questions[7][1] = "Es maravilloso y toda una experiencia.";
        questions[7][2] = "Es como una montaña rusa.";
        questions[7][3] = "Debo tener responsabilidad afectiva.";
        questions[7][4] = "El amor no existe.";

        questions[8][0] = "¿Te es fácil entablar una conversación con un extraño?";
        questions[8][1] = "Sí, es super fácil.";
        questions[8][2] = "Más o menos.";    
        questions[8][3] = "Me da pena pero podría intentarlo.";
        questions[8][4] = "No, me aterra.";

        questions[9][0] = "¿Sientes una necesidad de tener pareja o estar acompañad@?";
        questions[9][1] = "Disfruto la compañía pero puedo estar solo sin ningún problema.";
        questions[9][2] = "Sí, me aterra mi soledad.";
        questions[9][3] = "No, soy autónomo.";
        questions[9][4] = "Me es indiferente.";
        //Creación de los botones de selección sin agregar texto a ellos.
        opt1 = new JRadioButton();//Se crea el botón sin el texto.
        opt1.setBounds(170, 520, 700, 30);//Modifica la posición en el eje X y Y, así cómo también las dimensiones del botón.
        opt1.setBackground(Color.WHITE);//Color del fondo del botón.
        opt1.setFont(new Font("Times New Roman", Font.PLAIN, 25));//Fuente del texto que se insrrtará en el botón.
        add(opt1);//Se añade el componente especificado al final de este contenedor.
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(opt4);
        //Pase de parámetros.
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        //Generación del botón que permite continuar a la siguiente pregunta.
        next = new JButton("SIGUIENTE");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Josefin Sans", Font.BOLD, 18));
        next.setBackground(new Color(74, 57, 89));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        //Generación que permite continuar a la siguiente ventana donde se mostrarán los resultados.
        submit = new JButton("ENVIAR");
        submit.setBounds(1100, 630, 200, 40);
        submit.setFont(new Font("Josefin Sans", Font.BOLD, 18));
        submit.setBackground(new Color(194, 53, 77));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);//Modifica la visibilidad.
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == next) 
        {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            //Ciclo "For" que permite calcular el score (puntaje) del usuario en base a sus respuestas.
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(questions[i][1])) {
                    score += 10;
                } else if (useranswers[i][0].equals(questions[i][2])){
                    score += 8;
                } else if (useranswers[i][0].equals(questions[i][3])){
                    score += 6;
                } else if (useranswers[i][0].equals(questions[i][4])){
                    score += 4;
                } else{
                    score+=0;
                }
            }

            setVisible(false);//Modifica la visibilidad.
            new Score(name, score);//Se crea una instancia.
        }
    }
    
    public void paint(Graphics g) {//Creación del timer (temporizador).
        super.paint(g);
        String timeText = "TIEMPO RESTANTE:";
        String time =  timer + " SEG."; 
        g.setColor(Color.RED);
        g.setFont(new Font("Lucida Console", Font.BOLD, 25));
        //Impresión del timer en pantalla.
        if (timer > 0) { 
            g.drawString(timeText, 1080, 470);
            g.drawString(time, 1155, 510);
        } else {
            g.drawString("¡Se acabó el tiempo!", 1080, 500);
        }
        
        timer--;//Decrementa el valor del timer.
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            if (count == 9) {
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
            
                setVisible(false);
                new Score(name, score);
            } else { 
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++;//Incrementa el valor del contador.
                start(count);
            }
        }
        
        setSize(1450, 850);//Modifica las dimensiones de la ventana.
        //Se calcula mediante operaciones la posicion en el eje X y Y de la pantalla para colocar la ventana en el centro de la pantalla.
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int) screenSize.getWidth()/2;
        int centerY = (int) screenSize.getHeight()/2;
        setLocation(centerX - getWidth()/2, centerY - getHeight()/2);//Modifica la posición de la ventana.
        setVisible(true);//Modifica el estado de la visibilidad de la ventana.
    }
    //Asignaciones del texto a los botones.
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();//Limpia la selección.
    }
    
    public static void main(String[] args)//Función principal.
    {
        new Quiz("User");//Se crea una instancia.
    }
}