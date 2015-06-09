package Seguridad;

import Mantenimientos.Frm_Client_Search;
import Mantenimientos.Frm_Distribution_Center;
import Mantenimientos.Frm_Location_Cell_Search;
import Mantenimientos.Frm_PalletIni;
import Mantenimientos.Frm_PalletIni;
import Mantenimientos.Frm_PalletLocation;
import Mantenimientos.Frm_PalletLocation;
import Mantenimientos.Frm_PalletLocation_Search;
import Mantenimientos.Frm_PalletProduct;
import Mantenimientos.Frm_PalletProduct_Search;
import Mantenimientos.Frm_Pallet_SearchIni;
import Mantenimientos.Frm_Product_Search;
import Mantenimientos.Frm_Rack_Search;
import Mantenimientos.Frm_User_Search;
import Mantenimientos.Frm_Warehouse_Search;
import Model.Log;
import Model.Users;
import Operaciones.Frm_DispatchOrder_Search;
import Operaciones.Frm_IntermentOrder_Load;
import Operaciones.Frm_InternmentOrder_Search;
import Operaciones.Frm_Load_RequestOrder;
import Operaciones.Frm_PickingOrder_Search;
import Operaciones.Frm_RequestOrder_Search;
import Operaciones.Frm_ReturnProducts;
import Operaciones.Frm_ReturnProducts_Search;
//import Reportes.Frm_DiferenciaInventarioReport;
import Reportes.Frm_DispatchReport;
import Reportes.Frm_InternmentReport;
import Reportes.Frm_KardexReport;
import Reportes.Frm_LibreDisponibilidadReport;
import Reportes.Frm_StockReport;
import Reportes.Frm_TransportGuide;
import Simulacion_Algoritmica.Frm_Algorithmic_Simulator;
import dao.DaoLog;
import dao.DaoUsers;
import dao.impl.DaoLogImpl;
import dao.impl.DaoUserImpl;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Frm_MenuPrincipal extends javax.swing.JFrame {
    Users user = new Users();
   
    Frm_Login login = new Frm_Login();
    
    Log logSI = new Log();
    DaoLog daoLog =new DaoLogImpl();
    
    //gzavala-inicio 24/05
    public void access_windows_user(Integer idprofile)
    {  
            DaoUsers daoUsers = new DaoUserImpl();
            this.op_Centro_distribucion.setEnabled(daoUsers.accesswindow(idprofile,"op_Centro_distribucion"));
            this.op_Personal.setEnabled(daoUsers.accesswindow(idprofile,"op_Usuario"));
            this.op_Cliente.setEnabled(daoUsers.accesswindow(idprofile,"op_Cliente"));
            this.op_Producto.setEnabled(daoUsers.accesswindow(idprofile,"op_Producto"));
            this.op_Almacenes.setEnabled(daoUsers.accesswindow(idprofile,"op_Almacenes"));
            this.op_Racks.setEnabled(daoUsers.accesswindow(idprofile,"op_Racks"));
            this.op_Pallet.setEnabled(daoUsers.accesswindow(idprofile,"op_Pallet"));
            this.op_loadIntermentOrder.setEnabled(daoUsers.accesswindow(idprofile,"op_loadIntermentOrder"));
            this.op_searchInternmentOrder.setEnabled(daoUsers.accesswindow(idprofile,"op_searchInternmentOrder"));
            this.op_loadRequestOrders.setEnabled(daoUsers.accesswindow(idprofile,"op_loadRequestOrders"));
            this.op_RequestOrderSearch.setEnabled(daoUsers.accesswindow(idprofile,"op_RequestOrderSearch"));
            this.op_PickingOrderSearch.setEnabled(daoUsers.accesswindow(idprofile,"op_PickingOrderSearch"));
            this.op_DispatchOrderSearch.setEnabled(daoUsers.accesswindow(idprofile,"op_DispatchOrderSearch"));
            this.op_RegisterReturn.setEnabled(daoUsers.accesswindow(idprofile,"op_RegisterReturn"));
            this.op_ReturnSearch.setEnabled(daoUsers.accesswindow(idprofile,"op_ReturnSearch"));
            this.op_Carga_Datos.setEnabled(daoUsers.accesswindow(idprofile,"op_Carga_Datos"));
            this.op_Perfiles.setEnabled(daoUsers.accesswindow(idprofile,"op_Perfiles"));
            this.op_Cambio_Contraseña.setEnabled(daoUsers.accesswindow(idprofile,"op_Cambio_Contraseña"));
            this.op_Reporte_Internamiento.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_Internamiento"));
            this.op_Guia_Transportista.setEnabled(daoUsers.accesswindow(idprofile,"op_Guia_Transportista"));
            this.op_Reporte_Despacho.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_Despacho"));
            this.op_Reporte_diferencia_Inventario.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_diferencia_Inventario"));
            this.op_Reporte_Kardex_segun_fecha.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_Kardex_segun_fecha"));
            this.op_Reporte_Stock_fecha.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_Stock_fecha"));
            this.op_Reporte_Libre_disponibilidad.setEnabled(daoUsers.accesswindow(idprofile,"op_Reporte_Libre_disponibilidad"));
            this.op_Reporte_Libre_disponibilidad.setEnabled(daoUsers.accesswindow(idprofile,"op_generator_simulation"));            
            
        
      }
    //gzavala-fin 24/05
     
    
    public Frm_MenuPrincipal(Frm_Login log) {
        initComponents();
        login = log;
        

    }

    public Frm_MenuPrincipal() {

    }
    
    public Frm_MenuPrincipal(Frm_Login log,Users userAux) {
        initComponents();
        login = log;
        user = userAux;
        lbl_name.setText(user.getname());
        //gzavala-inicio 24/05
        access_windows_user(user.getProfile_idProfile());
        //gzavala-fin  24/05      
        logSI.setIduser(user.getIdUser());
        daoLog.clientIns("Se ha logueado al sistema", Frm_MenuPrincipal.class.toString(),logSI.getIduser());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        lbl_welcome = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menu_principal = new javax.swing.JMenuBar();
        menu_mantenimientos = new javax.swing.JMenu();
        op_Centro_distribucion = new javax.swing.JMenuItem();
        op_Personal = new javax.swing.JMenuItem();
        op_Cliente = new javax.swing.JMenuItem();
        op_Producto = new javax.swing.JMenuItem();
        op_Almacenes = new javax.swing.JMenuItem();
        op_Racks = new javax.swing.JMenuItem();
        jMenu_Pallet = new javax.swing.JMenu();
        op_Pallet = new javax.swing.JMenuItem();
        op_Pallet_Product = new javax.swing.JMenuItem();
        op_PalletProduct_Location = new javax.swing.JMenuItem();
        op_Location_Cell = new javax.swing.JMenuItem();
        menu_operaciones = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        op_loadIntermentOrder = new javax.swing.JMenuItem();
        op_searchInternmentOrder = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        op_loadRequestOrders = new javax.swing.JMenuItem();
        op_RequestOrderSearch = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        op_PickingOrderSearch = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        op_DispatchOrderSearch = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        op_RegisterReturn = new javax.swing.JMenuItem();
        op_ReturnSearch = new javax.swing.JMenuItem();
        op_Carga_Datos = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menu_seguridad = new javax.swing.JMenu();
        op_Perfiles = new javax.swing.JMenuItem();
        op_Cambio_Contraseña = new javax.swing.JMenuItem();
        menu_reportes = new javax.swing.JMenu();
        op_Reporte_Internamiento = new javax.swing.JMenuItem();
        op_Guia_Transportista = new javax.swing.JMenuItem();
        op_Reporte_Despacho = new javax.swing.JMenuItem();
        op_Reporte_diferencia_Inventario = new javax.swing.JMenuItem();
        op_Reporte_Kardex_segun_fecha = new javax.swing.JMenuItem();
        op_Reporte_Stock_fecha = new javax.swing.JMenuItem();
        op_Reporte_Libre_disponibilidad = new javax.swing.JMenuItem();
        menu_simulation = new javax.swing.JMenu();
        op_generator_simulation = new javax.swing.JMenuItem();
        menu_cerrarsesion = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lbl_welcome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_welcome.setForeground(new java.awt.Color(255, 255, 255));
        lbl_welcome.setText("Bienvenido:");
        getContentPane().add(lbl_welcome);
        lbl_welcome.setBounds(10, 670, 150, 30);

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setText("Nombre");
        getContentPane().add(lbl_name);
        lbl_name.setBounds(160, 670, 250, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/wms.png"))); // NOI18N
        jLabel1.setText("       ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1320, 840);

        menu_mantenimientos.setText("Mantenimientos");

        op_Centro_distribucion.setText("Centro de Distribución");
        op_Centro_distribucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Centro_distribucionActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Centro_distribucion);

        op_Personal.setText("Usuario");
        op_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_PersonalActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Personal);

        op_Cliente.setText("Cliente");
        op_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_ClienteActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Cliente);

        op_Producto.setText("Productos");
        op_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_ProductoActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Producto);

        op_Almacenes.setText("Almacenes");
        op_Almacenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_AlmacenesActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Almacenes);

        op_Racks.setText("Racks");
        op_Racks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_RacksActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Racks);

        jMenu_Pallet.setText("Pallet");

        op_Pallet.setText("Pallet");
        op_Pallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_PalletActionPerformed(evt);
            }
        });
        jMenu_Pallet.add(op_Pallet);

        op_Pallet_Product.setText("Pallet/Producto");
        op_Pallet_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Pallet_ProductActionPerformed(evt);
            }
        });
        jMenu_Pallet.add(op_Pallet_Product);

        op_PalletProduct_Location.setText("Ubicacion-Pallet/Producto");
        op_PalletProduct_Location.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_PalletProduct_LocationActionPerformed(evt);
            }
        });
        jMenu_Pallet.add(op_PalletProduct_Location);

        menu_mantenimientos.add(jMenu_Pallet);

        op_Location_Cell.setText("Celda de Ubicación");
        op_Location_Cell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Location_CellActionPerformed(evt);
            }
        });
        menu_mantenimientos.add(op_Location_Cell);

        menu_principal.add(menu_mantenimientos);

        menu_operaciones.setText("Operaciones");

        jMenu5.setText("Internamiento de Productos");

        op_loadIntermentOrder.setText("Cargar Órdenes de Internamiento");
        op_loadIntermentOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_loadIntermentOrderActionPerformed(evt);
            }
        });
        jMenu5.add(op_loadIntermentOrder);

        op_searchInternmentOrder.setText("Ver Órdenes de Internamiento");
        op_searchInternmentOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_searchInternmentOrderActionPerformed(evt);
            }
        });
        jMenu5.add(op_searchInternmentOrder);

        menu_operaciones.add(jMenu5);

        jMenu1.setText("Órdenes de Pedido");

        op_loadRequestOrders.setText("Cargar Órdenes de Pedido");
        op_loadRequestOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_loadRequestOrdersActionPerformed(evt);
            }
        });
        jMenu1.add(op_loadRequestOrders);

        op_RequestOrderSearch.setText("Ver Órdenes de Pedido");
        op_RequestOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_RequestOrderSearchActionPerformed(evt);
            }
        });
        jMenu1.add(op_RequestOrderSearch);

        menu_operaciones.add(jMenu1);

        jMenu2.setText("Órdenes de Entrega");

        op_PickingOrderSearch.setText("Ver Órdenes de Entrega");
        op_PickingOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_PickingOrderSearchActionPerformed(evt);
            }
        });
        jMenu2.add(op_PickingOrderSearch);

        menu_operaciones.add(jMenu2);

        jMenu3.setText("Órdenes de Despacho");

        op_DispatchOrderSearch.setText("Ver Órdenes de Despacho");
        op_DispatchOrderSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_DispatchOrderSearchActionPerformed(evt);
            }
        });
        jMenu3.add(op_DispatchOrderSearch);

        menu_operaciones.add(jMenu3);

        jMenu4.setText("Devolución de Productos");

        op_RegisterReturn.setText("Registrar Devolución");
        op_RegisterReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_RegisterReturnActionPerformed(evt);
            }
        });
        jMenu4.add(op_RegisterReturn);

        op_ReturnSearch.setText("Ver Devoluciones");
        op_ReturnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_ReturnSearchActionPerformed(evt);
            }
        });
        jMenu4.add(op_ReturnSearch);

        menu_operaciones.add(jMenu4);

        op_Carga_Datos.setText("Carga de Datos");
        op_Carga_Datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Carga_DatosActionPerformed(evt);
            }
        });
        menu_operaciones.add(op_Carga_Datos);

        jMenu6.setText("Ajustes y Movimientos");

        jMenuItem4.setText("Ajuste Manual");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem4);

        jMenuItem5.setText("Ajuste Automático");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Ajuste por Rotura");
        jMenu6.add(jMenuItem6);

        menu_operaciones.add(jMenu6);

        menu_principal.add(menu_operaciones);

        menu_seguridad.setText("Seguridad");

        op_Perfiles.setText("Perfiles");
        op_Perfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_PerfilesActionPerformed(evt);
            }
        });
        menu_seguridad.add(op_Perfiles);

        op_Cambio_Contraseña.setText("Cambio de Contraseña");
        op_Cambio_Contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                op_Cambio_ContraseñaMouseClicked(evt);
            }
        });
        op_Cambio_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Cambio_ContraseñaActionPerformed(evt);
            }
        });
        menu_seguridad.add(op_Cambio_Contraseña);

        menu_principal.add(menu_seguridad);

        menu_reportes.setText("Reportes");

        op_Reporte_Internamiento.setText("Reporte de Internamiento");
        op_Reporte_Internamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_InternamientoActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_Internamiento);

        op_Guia_Transportista.setText("Guia de Transportista ");
        op_Guia_Transportista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Guia_TransportistaActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Guia_Transportista);

        op_Reporte_Despacho.setText("Reporte de Despacho");
        op_Reporte_Despacho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_DespachoActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_Despacho);

        op_Reporte_diferencia_Inventario.setText("Reporte de diferencia de Inventario");
        op_Reporte_diferencia_Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_diferencia_InventarioActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_diferencia_Inventario);

        op_Reporte_Kardex_segun_fecha.setText("Reporte de Kardex segun fecha");
        op_Reporte_Kardex_segun_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_Kardex_segun_fechaActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_Kardex_segun_fecha);

        op_Reporte_Stock_fecha.setText("Reporte de Stock a la fecha");
        op_Reporte_Stock_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_Stock_fechaActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_Stock_fecha);

        op_Reporte_Libre_disponibilidad.setText("Reporte de Libre disponibilidad");
        op_Reporte_Libre_disponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_Reporte_Libre_disponibilidadActionPerformed(evt);
            }
        });
        menu_reportes.add(op_Reporte_Libre_disponibilidad);

        menu_principal.add(menu_reportes);

        menu_simulation.setText("Simulación Algorítmica");

        op_generator_simulation.setText("Realizar Simulación");
        op_generator_simulation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                op_generator_simulationActionPerformed(evt);
            }
        });
        menu_simulation.add(op_generator_simulation);

        menu_principal.add(menu_simulation);

        menu_cerrarsesion.setText("Cerrar Sesión");
        menu_cerrarsesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_cerrarsesionMouseClicked(evt);
            }
        });
        menu_principal.add(menu_cerrarsesion);

        setJMenuBar(menu_principal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void op_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_PersonalActionPerformed

        Frm_User_Search frm_user = new Frm_User_Search(this);
        frm_user.setVisible(true);
        frm_user.setLocationRelativeTo(null);

    }//GEN-LAST:event_op_PersonalActionPerformed

    private void op_Reporte_Stock_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_Stock_fechaActionPerformed
         Frm_StockReport frm_Stock = new Frm_StockReport(this);
        frm_Stock.setVisible(true);
        frm_Stock.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Reporte_Stock_fechaActionPerformed

    private void op_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_ProductoActionPerformed
        Frm_Product_Search frmProducts = new Frm_Product_Search(this);
        frmProducts.setVisible(true);
        frmProducts.setLocationRelativeTo(null);

    }//GEN-LAST:event_op_ProductoActionPerformed

    private void op_Carga_DatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Carga_DatosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_op_Carga_DatosActionPerformed

    private void menu_cerrarsesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_cerrarsesionMouseClicked
        // TODO add your handling code here:
//        JOptionPane.showMessageDialog(this, "Cerrando Sesion");
//        login.setVisible(true);
//        this.dispose();
        String message = "¿Está seguro que desea cerrar sesión?";
        String title = "Cerrar Sesión";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            login.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_menu_cerrarsesionMouseClicked

    private void op_Cambio_ContraseñaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_op_Cambio_ContraseñaMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_op_Cambio_ContraseñaMouseClicked

    private void op_Cambio_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Cambio_ContraseñaActionPerformed
        // TODO add your handling code here:
        Frm_Change_Password_Admin frmRestablecer_contrasena = new Frm_Change_Password_Admin(this);
        frmRestablecer_contrasena.setVisible(true);
        frmRestablecer_contrasena.setLocationRelativeTo(null);


    }//GEN-LAST:event_op_Cambio_ContraseñaActionPerformed

    private void op_Centro_distribucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Centro_distribucionActionPerformed
        // TODO add your handling code here:
        Frm_Distribution_Center frm_centro_distribucion = new Frm_Distribution_Center(this);
        frm_centro_distribucion.setVisible(true);
        frm_centro_distribucion.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Centro_distribucionActionPerformed

    private void op_RacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_RacksActionPerformed
        Frm_Rack_Search frm_rack_search = new Frm_Rack_Search(this);
        frm_rack_search.setVisible(true);
        frm_rack_search.setLocation(300, 100);
        frm_rack_search.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_RacksActionPerformed

    private void op_AlmacenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_AlmacenesActionPerformed
        // TODO add your handling code here:
        Frm_Warehouse_Search frm_warehouse = new Frm_Warehouse_Search(this);
        frm_warehouse.setVisible(true);
        frm_warehouse.setLocation(300, 100);
        frm_warehouse.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_AlmacenesActionPerformed

    private void op_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_ClienteActionPerformed
        Frm_Client_Search frm_Client_Search = new Frm_Client_Search(this);
        frm_Client_Search.setVisible(true);
        frm_Client_Search.setLocationRelativeTo(null);
        this.setEnabled(false);

    }//GEN-LAST:event_op_ClienteActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
        this.setEnabled(false);
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        this.setEnabled(true);
    }//GEN-LAST:event_formWindowGainedFocus

    private void op_PickingOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_PickingOrderSearchActionPerformed
        // TODO add your handling code here:}
        Frm_PickingOrder_Search frm_spo = new Frm_PickingOrder_Search(this);
        frm_spo.setVisible(true);
        frm_spo.setLocation(450, 150);
        frm_spo.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_PickingOrderSearchActionPerformed

    private void op_DispatchOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_DispatchOrderSearchActionPerformed
        // TODO add your handling code here:
        Frm_DispatchOrder_Search frm_vod = new Frm_DispatchOrder_Search(this);
        frm_vod.setVisible(true);
        frm_vod.setLocation(450, 150);
        frm_vod.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_DispatchOrderSearchActionPerformed

    private void op_loadRequestOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_loadRequestOrdersActionPerformed
        // TODO add your handling code here:
        Frm_Load_RequestOrder frm_op = new Frm_Load_RequestOrder(this,user);
        frm_op.setVisible(true);
        frm_op.setLocation(450, 150);
        frm_op.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_loadRequestOrdersActionPerformed

    private void op_RequestOrderSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_RequestOrderSearchActionPerformed
        // TODO add your handling code here:
        Frm_RequestOrder_Search frm_sro = new Frm_RequestOrder_Search(this);
        frm_sro.setVisible(true);
        frm_sro.setLocation(450, 150);
        frm_sro.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_RequestOrderSearchActionPerformed

    private void op_RegisterReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_RegisterReturnActionPerformed
        // TODO add your handling code here:
        Frm_ReturnProducts frm_rp = new Frm_ReturnProducts(this);
        frm_rp.setVisible(true);
        frm_rp.setLocation(450, 150);
        frm_rp.setLocationRelativeTo(null);

    }//GEN-LAST:event_op_RegisterReturnActionPerformed

    private void op_ReturnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_ReturnSearchActionPerformed
        // TODO add your handling code here:
        Frm_ReturnProducts_Search frm_rps = new Frm_ReturnProducts_Search(this);
        frm_rps.setVisible(true);
        frm_rps.setLocation(450, 150);
        frm_rps.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_ReturnSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        String message = "¿Está seguro que desea cerrar sesión?";
        String title = "Cerrar Sesión";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            login.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_formWindowClosing

    //gzavala-inicio 19/05
    private void op_PalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_PalletActionPerformed
    //gzavala-inicio 24/05 23:45    
        //Frm_Pallet_Search frm_pallet = new Frm_Pallet_Search(this);
        Frm_Pallet_SearchIni frm_pallet = new Frm_Pallet_SearchIni(this);
    //gzavala-fin 24/05 23:45    
        frm_pallet.setVisible(true);
        frm_pallet.setLocation(450, 150);
        frm_pallet.setLocationRelativeTo(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_op_PalletActionPerformed
    //gzavala-fin 19/05

    private void op_PerfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_PerfilesActionPerformed
        // TODO add your handling code here:
        Frm_Profile_Search frm_profile_search = new Frm_Profile_Search(this);
        frm_profile_search.setVisible(true);
        frm_profile_search.setLocation(300, 100);
        frm_profile_search.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_PerfilesActionPerformed

    private void op_Reporte_DespachoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_DespachoActionPerformed
        Frm_DispatchReport depRep = new Frm_DispatchReport(this);
        depRep.setVisible(true);
        depRep.setLocationRelativeTo(null);
        this.setEnabled(false);
    }//GEN-LAST:event_op_Reporte_DespachoActionPerformed

    private void op_Reporte_InternamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_InternamientoActionPerformed
        Frm_InternmentReport frm_InternmentReport=new Frm_InternmentReport(this);
        frm_InternmentReport.setVisible(true);
        frm_InternmentReport.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Reporte_InternamientoActionPerformed

    private void op_Guia_TransportistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Guia_TransportistaActionPerformed
        Frm_TransportGuide guide = new Frm_TransportGuide(this);
        guide.setVisible(true);
        guide.setLocationRelativeTo(null);
        this.setEnabled(false);
    }//GEN-LAST:event_op_Guia_TransportistaActionPerformed
    private void op_loadIntermentOrderActionPerformed(java.awt.event.ActionEvent evt) {
        Frm_IntermentOrder_Load frm_prodIntLoad = new Frm_IntermentOrder_Load(this);
        frm_prodIntLoad.setVisible(true);
        frm_prodIntLoad.setLocation(300,100);
        frm_prodIntLoad.setLocationRelativeTo(null);
    }
    
    private void op_searchInternmentOrderActionPerformed(java.awt.event.ActionEvent evt) {
        Frm_InternmentOrder_Search frm_prodIntSearch = new Frm_InternmentOrder_Search(this);
        frm_prodIntSearch.setVisible(true);
        frm_prodIntSearch.setLocation(300,100);
        frm_prodIntSearch.setLocationRelativeTo(null);
    }
    
    private void op_generator_simulationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_generator_simulationActionPerformed
        // TODO add your handling code here:
        Frm_Algorithmic_Simulator frm_as = new Frm_Algorithmic_Simulator(this);
        frm_as.setVisible(true);
        frm_as.setLocation(300,100);
        frm_as.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_op_generator_simulationActionPerformed

//gzavala-inicio 24/05 23:45    
    private void op_Pallet_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Pallet_ProductActionPerformed
        // TODO add your handling code here:
        //gzavala-inicio 27/05 13:20 Se actualiza la llamada al formulario 
        //Frm_Pallet_Search frm_pallet = new Frm_Pallet_Search(this);
        Frm_PalletProduct_Search frm_pallet = new  Frm_PalletProduct_Search(this);
        //gzavala-fin 27/05 13:20
        frm_pallet.setVisible(true);
        frm_pallet.setLocation(450, 150);
        frm_pallet.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_op_Pallet_ProductActionPerformed

    private void op_PalletProduct_LocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_PalletProduct_LocationActionPerformed
        // TODO add your handling code here:
        Frm_PalletLocation_Search frm_pallet = new Frm_PalletLocation_Search(this);
        frm_pallet.setVisible(true);
        frm_pallet.setLocation(450, 150);
        frm_pallet.setLocationRelativeTo(null);

    }//GEN-LAST:event_op_PalletProduct_LocationActionPerformed

    private void op_Reporte_Kardex_segun_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_Kardex_segun_fechaActionPerformed
        Frm_KardexReport frm_kardex = new Frm_KardexReport(this);
        frm_kardex.setVisible(true);
        frm_kardex.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Reporte_Kardex_segun_fechaActionPerformed

    private void op_Location_CellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Location_CellActionPerformed
        Frm_Location_Cell_Search frm_location_cell_search = new Frm_Location_Cell_Search(this);
        frm_location_cell_search.setVisible(true);        
        frm_location_cell_search.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Location_CellActionPerformed

    private void op_Reporte_Libre_disponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_Libre_disponibilidadActionPerformed
        Frm_LibreDisponibilidadReport frm_LibreDisponibilidadReport = new Frm_LibreDisponibilidadReport(this);
        frm_LibreDisponibilidadReport.setVisible(true);
        frm_LibreDisponibilidadReport.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Reporte_Libre_disponibilidadActionPerformed

    private void op_Reporte_diferencia_InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_op_Reporte_diferencia_InventarioActionPerformed
//        Frm_DiferenciaInventarioReport frm_DiferenciaInventarioReport = new Frm_DiferenciaInventarioReport(this);
//        frm_DiferenciaInventarioReport.setVisible(true);
//        frm_DiferenciaInventarioReport.setLocationRelativeTo(null);
    }//GEN-LAST:event_op_Reporte_diferencia_InventarioActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed
//gzavala-fin 24/05 23:45    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jMenu_Pallet;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_welcome;
    private javax.swing.JMenu menu_cerrarsesion;
    private javax.swing.JMenu menu_mantenimientos;
    private javax.swing.JMenu menu_operaciones;
    private javax.swing.JMenuBar menu_principal;
    private javax.swing.JMenu menu_reportes;
    private javax.swing.JMenu menu_seguridad;
    private javax.swing.JMenu menu_simulation;
    private javax.swing.JMenuItem op_Almacenes;
    private javax.swing.JMenuItem op_Cambio_Contraseña;
    private javax.swing.JMenuItem op_Carga_Datos;
    private javax.swing.JMenuItem op_Centro_distribucion;
    private javax.swing.JMenuItem op_Cliente;
    private javax.swing.JMenuItem op_DispatchOrderSearch;
    private javax.swing.JMenuItem op_Guia_Transportista;
    private javax.swing.JMenuItem op_Location_Cell;
    private javax.swing.JMenuItem op_Pallet;
    private javax.swing.JMenuItem op_PalletProduct_Location;
    private javax.swing.JMenuItem op_Pallet_Product;
    private javax.swing.JMenuItem op_Perfiles;
    private javax.swing.JMenuItem op_Personal;
    private javax.swing.JMenuItem op_PickingOrderSearch;
    private javax.swing.JMenuItem op_Producto;
    private javax.swing.JMenuItem op_Racks;
    private javax.swing.JMenuItem op_RegisterReturn;
    private javax.swing.JMenuItem op_Reporte_Despacho;
    private javax.swing.JMenuItem op_Reporte_Internamiento;
    private javax.swing.JMenuItem op_Reporte_Kardex_segun_fecha;
    private javax.swing.JMenuItem op_Reporte_Libre_disponibilidad;
    private javax.swing.JMenuItem op_Reporte_Stock_fecha;
    private javax.swing.JMenuItem op_Reporte_diferencia_Inventario;
    private javax.swing.JMenuItem op_RequestOrderSearch;
    private javax.swing.JMenuItem op_ReturnSearch;
    private javax.swing.JMenuItem op_generator_simulation;
    private javax.swing.JMenuItem op_loadIntermentOrder;
    private javax.swing.JMenuItem op_loadRequestOrders;
    private javax.swing.JMenuItem op_searchInternmentOrder;
    // End of variables declaration//GEN-END:variables
}
