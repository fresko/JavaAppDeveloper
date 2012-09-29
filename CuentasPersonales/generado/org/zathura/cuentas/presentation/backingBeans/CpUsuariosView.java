package org.zathura.cuentas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.RowEditEvent;

import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpUsuariosDTO;
import org.zathura.cuentas.presentation.businessDelegate.BusinessDelegatorView;
import org.zathura.cuentas.utilities.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public class CpUsuariosView {
    private InputText txtActivo;
    private InputText txtApellido;
    private InputText txtContrasena;
    private InputText txtCorreo;
    private InputText txtMovil;
    private InputText txtNombre;
    private InputText txtObservaciones;
    private InputText txtIdUsuario;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CpUsuariosDTO> data;
    private CpUsuariosDTO selectedCpUsuarios;

    public CpUsuariosView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CpUsuariosDTO cpUsuariosDTO = (CpUsuariosDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(cpUsuariosDTO.getActivo());

            if (txtApellido == null) {
                txtApellido = new InputText();
            }

            txtApellido.setValue(cpUsuariosDTO.getApellido());

            if (txtContrasena == null) {
                txtContrasena = new InputText();
            }

            txtContrasena.setValue(cpUsuariosDTO.getContrasena());

            if (txtCorreo == null) {
                txtCorreo = new InputText();
            }

            txtCorreo.setValue(cpUsuariosDTO.getCorreo());

            if (txtMovil == null) {
                txtMovil = new InputText();
            }

            txtMovil.setValue(cpUsuariosDTO.getMovil());

            if (txtNombre == null) {
                txtNombre = new InputText();
            }

            txtNombre.setValue(cpUsuariosDTO.getNombre());

            if (txtObservaciones == null) {
                txtObservaciones = new InputText();
            }

            txtObservaciones.setValue(cpUsuariosDTO.getObservaciones());

            if (txtIdUsuario == null) {
                txtIdUsuario = new InputText();
            }

            txtIdUsuario.setValue(cpUsuariosDTO.getIdUsuario());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
        }

        if (txtApellido != null) {
            txtApellido.setValue(null);
            txtApellido.setDisabled(true);
        }

        if (txtContrasena != null) {
            txtContrasena.setValue(null);
            txtContrasena.setDisabled(true);
        }

        if (txtCorreo != null) {
            txtCorreo.setValue(null);
            txtCorreo.setDisabled(true);
        }

        if (txtMovil != null) {
            txtMovil.setValue(null);
            txtMovil.setDisabled(true);
        }

        if (txtNombre != null) {
            txtNombre.setValue(null);
            txtNombre.setDisabled(true);
        }

        if (txtObservaciones != null) {
            txtObservaciones.setValue(null);
            txtObservaciones.setDisabled(true);
        }

        if (txtIdUsuario != null) {
            txtIdUsuario.setValue(null);
            txtIdUsuario.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        if (btnModify != null) {
            btnModify.setDisabled(true);
        }

        if (btnClear != null) {
            btnClear.setDisabled(false);
        }

        return "";
    }

    public void listener_txtId() {
        CpUsuarios entity = null;

        try {
            Long idUsuario = new Long(txtIdUsuario.getValue().toString());
            entity = BusinessDelegatorView.getCpUsuarios(idUsuario);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtApellido.setDisabled(false);
            txtContrasena.setDisabled(false);
            txtCorreo.setDisabled(false);
            txtMovil.setDisabled(false);
            txtNombre.setDisabled(false);
            txtObservaciones.setDisabled(false);
            txtIdUsuario.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtApellido.setValue(entity.getApellido());
            txtApellido.setDisabled(false);
            txtContrasena.setValue(entity.getContrasena());
            txtContrasena.setDisabled(false);
            txtCorreo.setValue(entity.getCorreo());
            txtCorreo.setDisabled(false);
            txtMovil.setValue(entity.getMovil());
            txtMovil.setDisabled(false);
            txtNombre.setValue(entity.getNombre());
            txtNombre.setDisabled(false);
            txtObservaciones.setValue(entity.getObservaciones());
            txtObservaciones.setDisabled(false);
            txtIdUsuario.setValue(entity.getIdUsuario());
            txtIdUsuario.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            BusinessDelegatorView.saveCpUsuarios(FacesUtils.checkString(
                    txtActivo), FacesUtils.checkString(txtApellido),
                FacesUtils.checkString(txtContrasena),
                FacesUtils.checkString(txtCorreo),
                FacesUtils.checkLong(txtIdUsuario),
                FacesUtils.checkLong(txtMovil),
                FacesUtils.checkString(txtNombre),
                FacesUtils.checkString(txtObservaciones));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            BusinessDelegatorView.deleteCpUsuarios(FacesUtils.checkLong(
                    txtIdUsuario));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            BusinessDelegatorView.updateCpUsuarios(FacesUtils.checkString(
                    txtActivo), FacesUtils.checkString(txtApellido),
                FacesUtils.checkString(txtContrasena),
                FacesUtils.checkString(txtCorreo),
                FacesUtils.checkLong(txtIdUsuario),
                FacesUtils.checkLong(txtMovil),
                FacesUtils.checkString(txtNombre),
                FacesUtils.checkString(txtObservaciones));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
            action_clear();
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String actionDeleteDataTableEditable() {
        try {
            if (txtIdUsuario == null) {
                txtIdUsuario = new InputText();
            }

            txtIdUsuario.setValue(selectedCpUsuarios.getIdUsuario());

            BusinessDelegatorView.deleteCpUsuarios(FacesUtils.checkLong(
                    txtIdUsuario));
            data.remove(selectedCpUsuarios);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String activo, String apellido,
        String contrasena, String correo, Long idUsuario, Long movil,
        String nombre, String observaciones) throws Exception {
        try {
            BusinessDelegatorView.updateCpUsuarios(activo, apellido,
                contrasena, correo, idUsuario, movil, nombre, observaciones);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CpUsuariosView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtContrasena() {
        return txtContrasena;
    }

    public void setTxtContrasena(InputText txtContrasena) {
        this.txtContrasena = txtContrasena;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public InputText getTxtMovil() {
        return txtMovil;
    }

    public void setTxtMovil(InputText txtMovil) {
        this.txtMovil = txtMovil;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(InputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    public InputText getTxtIdUsuario() {
        return txtIdUsuario;
    }

    public void setTxtIdUsuario(InputText txtIdUsuario) {
        this.txtIdUsuario = txtIdUsuario;
    }

    public List<CpUsuariosDTO> getData() {
        try {
            if (data == null) {
                data = BusinessDelegatorView.getDataCpUsuarios();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CpUsuariosDTO> cpUsuariosDTO) {
        this.data = cpUsuariosDTO;
    }

    public CpUsuariosDTO getSelectedCpUsuarios() {
        return selectedCpUsuarios;
    }

    public void setSelectedCpUsuarios(CpUsuariosDTO cpUsuarios) {
        this.selectedCpUsuarios = cpUsuarios;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }
}
