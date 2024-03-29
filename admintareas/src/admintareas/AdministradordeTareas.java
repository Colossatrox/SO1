/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package admintareas;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

/**
 *
 * @author David Hurtado
 */
public class AdministradordeTareas extends javax.swing.JFrame {
    String datos[][];
    int cant;
    //Definimos la variable TableModel para tomar el modelo de la tabla y asi poder configurarla
    DefaultTableModel TableModel;
    String[] strHeader={"                Procesos Actuales", "Memoria"};//Titulo de la tabla
    String[][] strData=null; //Declaracion de matriz
    int x,y; //Parametros para mouse
         //Declaracion del administrador
    public AdministradordeTareas() {
       initComponents();
       this.setLocationRelativeTo(null);//Ventana principal centrada en pantalla
       btnProcesos.setFocusable(false); //boton en un inicio invisible
       TableModel= new DefaultTableModel(strData,strHeader);     
       this.tblVistaProcesos.setModel(TableModel);  //Ajustamos el modelo
       this.setSize(750, 550); //Ajustar tamaño de la ventana
       JTableHeader thead=tblVistaProcesos.getTableHeader(); //creamos objeto de tipo header
       thead.setForeground(Color.blue); //Cambiamos color al encabezado
        
        
     }
    //Procedimiento para llamar a todos los procesos del sistema
    public List EjecucionProcesos() {
        List<String> LstrProcesos = new ArrayList<String>(); //Creamos una variable de tipo List (vector)
        try {
            String strLineas;
            //Llamamos al tasklist 
            Process p = Runtime.getRuntime().exec("tasklist.exe /nh"); //comando para llamar a mostrar todos los comandos y guardamos en p
            BufferedReader buffRinput = new BufferedReader //Creacion de variable tipo bufferedreader
        (new InputStreamReader(p.getInputStream())); //aplicamos inputstreamreader a p
            while ((strLineas = buffRinput.readLine()) != null) {
                if (!strLineas.trim().equals("")) {
                    LstrProcesos.add(strLineas.substring(0, strLineas.indexOf(" ")));
                }
            }
            buffRinput.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
        return LstrProcesos; //retornamos el vector
}
    
    public void ProcesosTabla(){
        cant=0;// variable para con
        try {
            String strLineas;
            //Llamamos al tasklist 
            Process p = Runtime.getRuntime().exec("tasklist.exe /nh"); //comando para llamar a mostrar todos los comandos y guardamos en p
            BufferedReader buffRinput = new BufferedReader //Creacion de variable tipo bufferedreader
        (new InputStreamReader(p.getInputStream())); //aplicamos inputstreamreader a p
            while ((strLineas = buffRinput.readLine()) != null) {//Mientras la linea que se lea sea diferente de nulo hacemos uqe
                if (!strLineas.trim().equals("")) {
                    if (strLineas.contains(".exe")) {//si la variable string contiene la palabra .exe
                        datos[cant][0]=strLineas.substring(0, strLineas.indexOf(".exe")+4);//Este guarda en la matriz el nombre del proceso
                    }else{//si no
                        datos[cant][0]=strLineas.substring(0,25);//Solamente guarda el nombre del proceso sin el .exe
                    }
                    try{
                       if (strLineas.contains("Services ")) {//si la oalabra contiene Services
                            datos[cant][1]=strLineas.substring(strLineas.indexOf("Services ")+30,strLineas.indexOf("K")+1);//Guarada la memoria que consume el proceso
                        }else if (strLineas.contains("Console ")){//si la oalabra contiene Console
                            datos[cant][1]=strLineas.substring(strLineas.indexOf("Console ")+30,strLineas.indexOf("K")+1);//Guarada la memoria que consume el proceso
                        }else{// sino
                            datos[cant][1]=strLineas.substring(strLineas.indexOf(".exe ")+60,strLineas.indexOf("K")+1);//Guarada la memoria que consume el proceso
                        }
                    }catch(Exception e){                        
                    }
                    
                    cant++;//sumamos 1
                }
            }
            buffRinput.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }
}
//Limpia la tabla por medio de un for
    void LimpiarTabla(){
        int intVar =TableModel.getRowCount()-1;  //toma la cantidad por mediatable
            for(int i=intVar;i>=0;i--){  //Índices van de 0 a n
            TableModel.removeRow(i); //Eliminar fila en cada iteracion
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Options = new javax.swing.JPanel();
        MinimizeP = new javax.swing.JLabel();
        CloseProgram = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVistaProcesos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        buttonTask2 = new org.edisoncor.gui.button.ButtonTask();
        labelMetric1 = new org.edisoncor.gui.label.LabelMetric();
        btnProcesos = new org.edisoncor.gui.textField.TextFieldRound();
        buttonTask1 = new org.edisoncor.gui.button.ButtonTask();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Options.setBackground(new java.awt.Color(0, 153, 255));
        Options.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Options.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                OptionsMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                OptionsMouseMoved(evt);
            }
        });
        Options.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                OptionsMousePressed(evt);
            }
        });
        Options.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MinimizeP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/minimize_78340.png"))); // NOI18N
        MinimizeP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MinimizeP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinimizePMouseClicked(evt);
            }
        });
        Options.add(MinimizeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 40, 30));

        CloseProgram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/cerrar.png"))); // NOI18N
        CloseProgram.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CloseProgram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseProgramMouseClicked(evt);
            }
        });
        Options.add(CloseProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        getContentPane().add(Options, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVistaProcesos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        tblVistaProcesos.setFont(new java.awt.Font("Gulim", 1, 12)); // NOI18N
        tblVistaProcesos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "PROCESOS"
            }
        ));
        tblVistaProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVistaProcesosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVistaProcesos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 390, 320));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabel1.setText("ADMINISTRADOR DE TAREAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, 38));

        buttonTask2.setBackground(new java.awt.Color(0, 0, 0));
        buttonTask2.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/show.png"))); // NOI18N
        buttonTask2.setText(" ");
        buttonTask2.setCategorySmallFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        buttonTask2.setDescription("MOSTRAR PROCESOS");
        buttonTask2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask2ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTask2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 275, 59));

        labelMetric1.setBackground(new java.awt.Color(255, 255, 255));
        labelMetric1.setForeground(new java.awt.Color(0, 0, 0));
        labelMetric1.setText("#PROCESOS");
        labelMetric1.setColorDeSombra(new java.awt.Color(102, 153, 255));
        labelMetric1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jPanel1.add(labelMetric1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 120, 30));

        btnProcesos.setForeground(new java.awt.Color(0, 102, 153));
        btnProcesos.setFont(new java.awt.Font("Palatino Linotype", 2, 18)); // NOI18N
        btnProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcesosMouseClicked(evt);
            }
        });
        jPanel1.add(btnProcesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 108, -1));

        buttonTask1.setForeground(new java.awt.Color(255, 255, 255));
        buttonTask1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/empleado.png"))); // NOI18N
        buttonTask1.setText(" ");
        buttonTask1.setCategorySmallFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        buttonTask1.setDescription("MATAR PROCESO");
        buttonTask1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTask1ActionPerformed(evt);
            }
        });
        jPanel1.add(buttonTask1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 280, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGES/MOUNT.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 760, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProcesosMouseClicked

    }//GEN-LAST:event_btnProcesosMouseClicked

    private void buttonTask2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask2ActionPerformed
        LimpiarTabla(); //Llamamos al metodo de limpiar tabla
        List<String> LstrProceso = EjecucionProcesos(); //Creacion variable tipo List
        this.btnProcesos.setText(String.valueOf(LstrProceso.size())); //Colocamos el numero de procesos
        datos=new String[LstrProceso.size()][2];//el string daros sera igual a lo que tenfa la lista lstrPRoceso
        ProcesosTabla();//llamamos al metodo
        System.out.println(datos[4][0]);
        for (int i = 0; i < cant; i++) {//el for ira de 0 hasta el numero de filas que contamos en el metodo Proceso Tabla
            Object[] objVar={datos[i][0], datos[i][1]};
            TableModel.addRow(objVar);//Agregamos las fialas a la tabla
        }
    }//GEN-LAST:event_buttonTask2ActionPerformed

    private void tblVistaProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVistaProcesosMouseClicked

    }//GEN-LAST:event_tblVistaProcesosMouseClicked
void actualizar(){
    try {
        Thread.sleep(1000); //Se crea un delay
    }catch (InterruptedException ex) {
        Logger.getLogger(AdministradordeTareas.class.getName()).log(Level.SEVERE, null, ex);
    }
         List<String> LstrProceso = EjecucionProcesos(); //Creacion variable tipo List
        this.btnProcesos.setText(String.valueOf(LstrProceso.size())); //Colocamos el numero de procesos
        datos=new String[LstrProceso.size()][2];//el string daros sera igual a lo que tenfa la lista lstrPRoceso
        ProcesosTabla();//llamamos al metodo
        System.out.println(datos[4][0]);
        for (int i = 0; i < cant; i++) {//el for ira de 0 hasta el numero de filas que contamos en el metodo Proceso Tabla
            Object[] objVar={datos[i][0], datos[i][1]};
            TableModel.addRow(objVar);//Agregamos las fialas a la tabla
        }
}
    private void buttonTask1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTask1ActionPerformed
        //Recibe como parámetro el nombre del proceso
        String strosName = System.getProperty("os.name");
        String strCmd="";
        DefaultTableModel dftmModelo = (DefaultTableModel) tblVistaProcesos.getModel();
        String strDato=String.valueOf(dftmModelo.getValueAt(tblVistaProcesos.getSelectedRow(),0));
        if(strDato!=""){
            if(strosName.toUpperCase().contains("WIN")){
                strCmd+="taskkill /IM "+strDato; //TASKKILL ES MATAR EL PROCESO e IM es para especificar el nombre del proceso
            }else{
                strCmd+="taskkill /IM "+strDato;
            }   
        Process proHijito;//una varibale del tipo Proccess
        try {
            proHijito = Runtime.getRuntime().exec(strCmd);//se ejecutara el comando que tenga strCMD
            proHijito.waitFor();
            if ( proHijito.exitValue()==0){//si es igual a 0
                LimpiarTabla(); //Llamamos al metodo para limpiar la tabla 
                actualizar();//llamamos al metodo para mostrar de buevo los procesos en la tabla
            }else{//si no muestra error
                JOptionPane.showMessageDialog(null,"Fue imposible destruir el Proceso! \nExcepcion: " + proHijito.exitValue()+"n");
            }
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"No es posible eliminar el Proceso");
        }catch (InterruptedException e){
            JOptionPane.showMessageDialog(null,"No es posible eliminar el Proceso");
        }
        }else{
            JOptionPane.showMessageDialog(null,"Proceso no seleccionado");
        }      
    
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonTask1ActionPerformed
 

    
    private void CloseProgramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseProgramMouseClicked
       //Programacion del boton de salida
        int respuesta=JOptionPane.showConfirmDialog(this, "Desea Salir de la Aplicación?","Confirmación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       if(respuesta==JOptionPane.YES_NO_OPTION){
           System.exit(0);
       }           
    }//GEN-LAST:event_CloseProgramMouseClicked

    private void MinimizePMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinimizePMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinimizePMouseClicked

    private void OptionsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptionsMousePressed
        // Obtener coordenadas de las posiciones x & y
        x=evt.getX(); 
        y=evt.getY();
        
    }//GEN-LAST:event_OptionsMousePressed

    private void OptionsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptionsMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_OptionsMouseMoved

    private void OptionsMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OptionsMouseDragged
        // Posicionamos nuestro frame usando las coordenadas del evento pressed
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_OptionsMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministradordeTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradordeTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradordeTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradordeTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministradordeTareas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseProgram;
    private javax.swing.JLabel MinimizeP;
    private javax.swing.JPanel Options;
    private org.edisoncor.gui.textField.TextFieldRound btnProcesos;
    private org.edisoncor.gui.button.ButtonTask buttonTask1;
    private org.edisoncor.gui.button.ButtonTask buttonTask2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.label.LabelMetric labelMetric1;
    private javax.swing.JTable tblVistaProcesos;
    // End of variables declaration//GEN-END:variables
}
