package org.zathura.cuentas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.RowEditEvent;

import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpTipoMovimientoDTO;
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
public class CpTipoMovimientoView {
    private InputText txtDescripcion;
    private InputText txtObservacion;
    private InputText txtIdTipoMovimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CpTipoMovimientoDTO> data;
    private CpTipoMovimientoDTO selectedCpTipoMovimiento;

    public CpTipoMovimientoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CpTipoMovimientoDTO cpTipoMovimientoDTO = (CpTipoMovimientoDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(cpTipoMovimientoDTO.getDescripcion());

            if (txtObservacion == null) {
                txtObservacion = new InputText();
            }

            txtObservacion.setValue(cpTipoMovimientoDTO.getObservacion());

            if (txtIdTipoMovimiento == null) {
                txtIdTipoMovimiento = new InputText();
            }

            txtIdTipoMovimiento.setValue(cpTipoMovimientoDTO.getIdTipoMovimiento());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDescripcion != null) {
            txtDescripcion.setValue(null);
            txtDescripcion.setDisabled(true);
        }

        if (txtObservacion != null) {
            txtObservacion.setValue(null);
            txtObservacion.setDisabled(true);
        }

        if (txtIdTipoMovimiento != null) {
            txtIdTipoMovimiento.setValue(null);
            txtIdTipoMovimiento.setDisabled(false);
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
        CpTipoMovimiento entity = null;

        try {
            Long idTipoMovimiento = new Long(txtIdTipoMovimiento.getValue()
                                                                .toString());
            entity = BusinessDelegatorView.getCpTipoMovimiento(idTipoMovimiento);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtObservacion.setDisabled(false);
            txtIdTipoMovimiento.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtObservacion.setValue(entity.getObservacion());
            txtObservacion.setDisabled(false);
            txtIdTipoMovimiento.setValue(entity.getIdTipoMovimiento());
            txtIdTipoMovimiento.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            BusinessDelegatorView.saveCpTipoMovimiento(FacesUtils.checkString(
                    txtDescripcion), FacesUtils.checkLong(txtIdTipoMovimiento),
                FacesUtils.checkString(txtObservacion));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            BusinessDelegatorView.deleteCpTipoMovimiento(FacesUtils.checkLong(
                    txtIdTipoMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            BusinessDelegatorView.updateCpTipoMovimiento(FacesUtils.checkString(
                    txtDescripcion), FacesUtils.checkLong(txtIdTipoMovimiento),
                FacesUtils.checkString(txtObservacion));
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
            if (txtIdTipoMovimiento == null) {
                txtIdTipoMovimiento = new InputText();
            }

            txtIdTipoMovimiento.setValue(selectedCpTipoMovimiento.getIdTipoMovimiento());

            BusinessDelegatorView.deleteCpTipoMovimiento(FacesUtils.checkLong(
                    txtIdTipoMovimiento));
            data.remove(selectedCpTipoMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcion,
        Long idTipoMovimiento, String observacion) throws Exception {
        try {
            BusinessDelegatorView.updateCpTipoMovimiento(descripcion,
                idTipoMovimiento, observacion);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CpTipoMovimientoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(InputText txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public InputText getTxtObservacion() {
        return txtObservacion;
    }

    public void setTxtObservacion(InputText txtObservacion) {
        this.txtObservacion = txtObservacion;
    }

    public InputText getTxtIdTipoMovimiento() {
        return txtIdTipoMovimiento;
    }

    public void setTxtIdTipoMovimiento(InputText txtIdTipoMovimiento) {
        this.txtIdTipoMovimiento = txtIdTipoMovimiento;
    }

    public List<CpTipoMovimientoDTO> getData() {
        try {
            if (data == null) {
                data = BusinessDelegatorView.getDataCpTipoMovimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CpTipoMovimientoDTO> cpTipoMovimientoDTO) {
        this.data = cpTipoMovimientoDTO;
    }

    public CpTipoMovimientoDTO getSelectedCpTipoMovimiento() {
        return selectedCpTipoMovimiento;
    }

    public void setSelectedCpTipoMovimiento(
        CpTipoMovimientoDTO cpTipoMovimiento) {
        this.selectedCpTipoMovimiento = cpTipoMovimiento;
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
