package com.agencia.menu.infrastructure.in;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
import com.agencia.aeropuerto.domain.service.AeropuertoService;
import com.agencia.aeropuerto.infrastructure.in.AeropuertoController;
import com.agencia.aeropuerto.infrastructure.out.AeropuertoRepository;
import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.service.ClienteService;
import com.agencia.cliente.infrastructure.in.ClienteController;
import com.agencia.cliente.infrastructure.out.ClienteRepository;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class inicio {
    public static void menu() throws SQLException {

        ClienteService clienteService = new ClienteRepository();
        CreateClienteCase createClienteCase = new CreateClienteCase(clienteService);
        FindClienteCase findClienteCase = new FindClienteCase(clienteService);
        UpdateClienteCase updateClienteCase = new UpdateClienteCase(clienteService);
        DeleteClienteCase deleteClienteCase = new DeleteClienteCase(clienteService);

        ClienteController clienteController = new ClienteController(
                clienteService,
                createClienteCase,
                findClienteCase,
                deleteClienteCase,
                updateClienteCase);

        AeropuertoService aeropuertoService = new AeropuertoRepository();
        CreateAeropuertoCase createAeropuertoCase = new CreateAeropuertoCase(aeropuertoService);
        FindAeropuertoCase findAeropuertoCase = new FindAeropuertoCase(aeropuertoService);
        UpdateAeropuertoCase updateAeropuertoCase = new UpdateAeropuertoCase(aeropuertoService);
        DeleteAeropuertoCase deleteAeropuertoCase = new DeleteAeropuertoCase(aeropuertoService);

        AeropuertoController aeropuertoController = new AeropuertoController(
                createAeropuertoCase,
                findAeropuertoCase,
                deleteAeropuertoCase,
                updateAeropuertoCase);

        ArrayList<String> tiposUsuario = new ArrayList<>();
        tiposUsuario.add("Cliente");
        tiposUsuario.add("Administrador");
        tiposUsuario.add("Tecnico");
        tiposUsuario.add("Agente de Ventas");

        JComboBox<String> comboBoxTipoUser = new JComboBox<>(tiposUsuario.toArray(new String[0]));

        JPanel panelTipoUser = new JPanel(new GridLayout(0, 1));
        panelTipoUser.add(new JLabel("Selecciona tu Usuario:"));
        panelTipoUser.add(comboBoxTipoUser);
        int result = JOptionPane.showConfirmDialog(null, panelTipoUser, "Seleccionar tipo Documento",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        String TipodeUsuario = null;
        if (result == JOptionPane.OK_OPTION) {
            TipodeUsuario = (String) comboBoxTipoUser.getSelectedItem();
        }

        if (TipodeUsuario.equals("Cliente")) {

            ArrayList<String> opcionCliente = new ArrayList<>();
            opcionCliente.add("Busca tu Vuelo");
            opcionCliente.add("Informacion de la Reserva de tu Vuelo");
            opcionCliente.add("Cancela la Reserva de tu Vuelo");
            opcionCliente.add("Edita la Reserva de tu Vuelo");
            JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionCliente.toArray(new String[0]));
            JPanel panelCliente = new JPanel(new GridLayout(0, 1));
            panelCliente.add(new JLabel("Cliente:"));
            panelCliente.add(comboBoxMenuAgente);

            int resultTipo = JOptionPane.showConfirmDialog(null, panelCliente, "Clientes",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String opcionSeleccionada = "";
            if (resultTipo == JOptionPane.OK_OPTION) {
                opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

            }
            int selectedIndex = -1;
            for (int i = 0; i < opcionCliente.size(); i++) {
                if (opcionCliente.get(i).equals(opcionSeleccionada)) {
                    selectedIndex = i + 1;
                    break;
                }
            }
            System.out.println(selectedIndex);

            switch (selectedIndex) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    break;
            }
        }

        if (TipodeUsuario.equals("Administrador")) {

            ArrayList<String> opcionesAdmin = new ArrayList<>();

            opcionesAdmin.add("Agregar Avión"); // 1
            opcionesAdmin.add("Editar Avión"); // 2
            opcionesAdmin.add("Eliminar Avión"); // 3
            opcionesAdmin.add("Información Avión"); // 4

            opcionesAdmin.add("Asignar Tripulación al Trayecto"); // 5
            opcionesAdmin.add("Información Trayecto"); // 6
            opcionesAdmin.add("Editar Trayecto"); // 7
            opcionesAdmin.add("Eliminar Trayecto"); // 8
            opcionesAdmin.add("Asignar Avión a un Trayecto"); // 9
            opcionesAdmin.add("Buscar Escalas de un Trayecto"); // 10
            opcionesAdmin.add("Editar Información de Escala"); // 11
            opcionesAdmin.add("Eliminar Escala"); // 12

            opcionesAdmin.add("Agregar Aeropuerto"); // 13
            opcionesAdmin.add("Editar Aeropuerto"); // 14
            opcionesAdmin.add("Eliminar Aeropuerto"); // 15
            opcionesAdmin.add("Información Aeropuerto"); // 16

            opcionesAdmin.add("Crear Tarifa de Vuelo"); // 17
            opcionesAdmin.add("Editar Tarifa de Vuelo"); // 18
            opcionesAdmin.add("Eliminar Tarifa de Vuelo"); // 19
            opcionesAdmin.add("Buscar Tarifa de Vuelo"); // 20

            opcionesAdmin.add("Crear Tipo de Documento"); // 21
            opcionesAdmin.add("Editar Tipo de Documento"); // 22
            opcionesAdmin.add("Eliminar Tipo de Documento"); // 23
            opcionesAdmin.add("Buscar según Tipo de Documento"); // 24

            opcionesAdmin.add("Buscar Información de Vuelo"); // 25
            opcionesAdmin.add("Buscar Asignación de Tripulación"); // 26
            JComboBox<String> comboBoxMenuAdmin = new JComboBox<>(opcionesAdmin.toArray(new String[0]));
            JPanel panelAdministrador = new JPanel(new GridLayout(0, 1));
            panelAdministrador.add(new JLabel("menu administrador:"));
            panelAdministrador.add(comboBoxMenuAdmin);

            int resultTipo = JOptionPane.showConfirmDialog(null, panelAdministrador, "Tipo Usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String opcionSeleccionada = "";
            if (resultTipo == JOptionPane.OK_OPTION) {
                opcionSeleccionada = (String) comboBoxMenuAdmin.getSelectedItem();

            }

            int selectedIndex = -1;
            for (int i = 0; i < opcionesAdmin.size(); i++) {
                if (opcionesAdmin.get(i).equals(opcionSeleccionada)) {
                    selectedIndex = i + 1;
                    break;
                }
            }
            System.out.println(selectedIndex);

            switch (selectedIndex) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    break;

                case 5:

                    break;

                case 6:
                    break;

                case 7:
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:

                    break;

                case 11:

                    break;

                case 12:

                    break;

                case 13:

                    aeropuertoController.crear();
                    break;

                case 14:

                    break;

                case 15:

                    break;

                case 16:

                    break;

                case 17:

                    break;

                case 18:

                    break;

                case 19:

                    break;

                case 20:

                    break;

                case 21:

                    break;

                case 22:

                    break;

                case 23:

                    break;

                case 24:

                    break;

                case 25:

                    break;

                case 26:

                    break;

                default:

                    break;
            }

        }

        if (TipodeUsuario.equals("Tecnico")) {

            ArrayList<String> opcionTecnico = new ArrayList<>();
            opcionTecnico.add(" Actualizar Información de Revisión");
            opcionTecnico.add("Eliminar Revisión de Mantenimiento");
            JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionTecnico.toArray(new String[0]));
            JPanel panelTecnico = new JPanel(new GridLayout(0, 1));
            panelTecnico.add(new JLabel("Tecnicos:"));
            panelTecnico.add(comboBoxMenuAgente);

            int resultTipo = JOptionPane.showConfirmDialog(null, panelTecnico, "tecnicos",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String opcionSeleccionada = "";
            if (resultTipo == JOptionPane.OK_OPTION) {
                opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

            }
            int selectedIndex = -1;
            for (int i = 0; i < opcionTecnico.size(); i++) {
                if (opcionTecnico.get(i).equals(opcionSeleccionada)) {
                    selectedIndex = i + 1;
                    break;
                }
            }
            System.out.println(selectedIndex);

            switch (selectedIndex) {
                case 1:

                    break;

                case 2:

                    break;

                default:
                    break;
            }

        }

        if (TipodeUsuario.equals("Agente de Ventas")) {

            ArrayList<String> opcionesAgente = new ArrayList<>();
            opcionesAgente.add("Crear Reserva de Vuelo"); // 1
            opcionesAgente.add("Eliminar Reserva de Vuelo"); // 2
            opcionesAgente.add("Información Reserva de Vuelo"); // 3

            opcionesAgente.add("Crear Cliente"); // 4
            opcionesAgente.add("Actualizar Información de Cliente"); // 5
            opcionesAgente.add("Información de Cliente"); // 6

            opcionesAgente.add("Información de Vuelo"); // 7
            opcionesAgente.add("Información Asignación de Tripulación"); // 8
            opcionesAgente.add("Información Escalas de un Trayecto"); // 9
            opcionesAgente.add("Información Tarifa de Vuelo"); // 10
            opcionesAgente.add("Información Tipo de Documento"); // 11

            JComboBox<String> comboBoxMenuAgente = new JComboBox<>(opcionesAgente.toArray(new String[0]));
            JPanel panelVentas = new JPanel(new GridLayout(0, 1));
            panelVentas.add(new JLabel("Agente Ventas:"));
            panelVentas.add(comboBoxMenuAgente);

            int resultTipo = JOptionPane.showConfirmDialog(null, panelVentas, "Tipo Usuario",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            String opcionSeleccionada = "";
            if (resultTipo == JOptionPane.OK_OPTION) {
                opcionSeleccionada = (String) comboBoxMenuAgente.getSelectedItem();

            }
            int selectedIndex = -1;
            for (int i = 0; i < opcionesAgente.size(); i++) {
                if (opcionesAgente.get(i).equals(opcionSeleccionada)) {
                    selectedIndex = i + 1;
                    break;
                }
            }
            System.out.println(selectedIndex);

            switch (selectedIndex) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    clienteController.crear();

                    break;

                case 5:
                    clienteController.actualizar();

                    break;

                case 6:
                    clienteController.buscar();

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:
                    break;

                case 10:
                    break;

                case 11:
                    break;

                default:
                    break;
            }
        }

    }
}
