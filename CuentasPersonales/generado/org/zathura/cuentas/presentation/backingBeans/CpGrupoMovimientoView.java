package org.zathura.cuentas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.RowEditEvent;

import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpGrupoMovimientoDTO;
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
public class CpGrupoMovimientoView {
    private InputText txtDescripcion;
    private InputText txtObservacion;
    private InputText txtIdTipoMovimiento_CpTipoMovimiento;
    private InputText txtIdGrupoMovimiento;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CpGrupoMovimientoDTO> data;
    private CpGrupoMovimientoDTO selectedCpGrupoMovimiento;

    public CpGrupoMovimientoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CpGrupoMovimientoDTO cpGrupoMovimientoDTO = (CpGrupoMovimientoDTO) e.getObject();

            if (txtDescripcion == null) {
                txtDescripcion = new InputText();
            }

            txtDescripcion.setValue(cpGrupoMovimientoDTO.getDescripcion());

            if (txtObservacion == null) {
                txtObservacion = new InputText();
            }

            txtObservacion.setValue(cpGrupoMovimientoDTO.getObservacion());

            if (txtIdTipoMovimiento_CpTipoMovimiento == null) {
                txtIdTipoMovimiento_CpTipoMovimiento = new InputText();
            }

            txtIdTipoMovimiento_CpTipoMovimiento.setValue(cpGrupoMovimientoDTO.getIdTipoMovimiento_CpTipoMovimiento());

            if (txtIdGrupoMovimiento == null) {
                txtIdGrupoMovimiento = new InputText();
            }

            txtIdGrupoMovimiento.setValue(cpGrupoMovimientoDTO.getIdGrupoMovimiento());

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

        if (txtIdTipoMovimiento_CpTipoMovimiento != null) {
            txtIdTipoMovimiento_CpTipoMovimiento.setValue(null);
            txtIdTipoMovimiento_CpTipoMovimiento.setDisabled(true);
        }

        if (txtIdGrupoMovimiento != null) {
            txtIdGrupoMovimiento.setValue(null);
            txtIdGrupoMovimiento.setDisabled(false);
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
        CpGrupoMovimiento entity = null;

        try {
            Long idGrupoMovimiento = new Long(txtIdGrupoMovimiento.getValue()
                                                                  .toString());
            entity = BusinessDelegatorView.getCpGrupoMovimiento(idGrupoMovimiento);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDescripcion.setDisabled(false);
            txtObservacion.setDisabled(false);
            txtIdTipoMovimiento_CpTipoMovimiento.setDisabled(false);
            txtIdGrupoMovimiento.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDescripcion.setValue(entity.getDescripcion());
            txtDescripcion.setDisabled(false);
            txtObservacion.setValue(entity.getObservacion());
            txtObservacion.setDisabled(false);
            txtIdTipoMovimiento_CpTipoMovimiento.setValue(entity.getCpTipoMovimiento()
                                                                .getIdTipoMovimiento());
            txtIdTipoMovimiento_CpTipoMovimiento.setDisabled(false);
            txtIdGrupoMovimiento.setValue(entity.getIdGrupoMovimiento());
            txtIdGrupoMovimiento.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            BusinessDelegatorView.saveCpGrupoMovimiento(FacesUtils.checkString(
                    txtDescripcion),
                FacesUtils.checkLong(txtIdGrupoMovimiento),
                FacesUtils.checkString(txtObservacion),
                FacesUtils.checkLong(txtIdTipoMovimiento_CpTipoMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            BusinessDelegatorView.deleteCpGrupoMovimiento(FacesUtils.checkLong(
                    txtIdGrupoMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            BusinessDelegatorView.updateCpGrupoMovimiento(FacesUtils.checkString(
                    txtDescripcion),
                FacesUtils.checkLong(txtIdGrupoMovimiento),
                FacesUtils.checkString(txtObservacion),
                FacesUtils.checkLong(txtIdTipoMovimiento_CpTipoMovimiento));
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
            if (txtIdGrupoMovimiento == null) {
                txtIdGrupoMovimiento = new InputText();
            }

            txtIdGrupoMovimiento.setValue(selectedCpGrupoMovimiento.getIdGrupoMovimiento());

            BusinessDelegatorView.deleteCpGrupoMovimiento(FacesUtils.checkLong(
                    txtIdGrupoMovimiento));
            data.remove(selectedCpGrupoMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcion,
        Long idGrupoMovimiento, String observacion,
        Long idTipoMovimiento_CpTipoMovimiento) throws Exception {
        try {
            BusinessDelegatorView.updateCpGrupoMovimiento(descripcion,
                idGrupoMovimiento, observacion,
                idTipoMovimiento_CpTipoMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CpGrupoMovimientoView").requestRender();
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

    public InputText getTxtIdTipoMovimiento_CpTipoMovimiento() {
        return txtIdTipoMovimiento_CpTipoMovimiento;
    }

    public void setTxtIdTipoMovimiento_CpTipoMovimiento(
        InputText txtIdTipoMovimiento_CpTipoMovimiento) {
        this.txtIdTipoMovimiento_CpTipoMovimiento = txtIdTipoMovimiento_CpTipoMovimiento;
    }

    public InputText getTxtIdGrupoMovimiento() {
        return txtIdGrupoMovimiento;
    }

    public void setTxtIdGrupoMovimiento(InputText txtIdGrupoMovimiento) {
        this.txtIdGrupoMovimiento = txtIdGrupoMovimiento;
    }

    public List<CpGrupoMovimientoDTO> getData() {
        try {
            if (data == null) {
                data = BusinessDelegatorView.getDataCpGrupoMovimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CpGrupoMovimientoDTO> cpGrupoMovimientoDTO) {
        this.data = cpGrupoMovimientoDTO;
    }

    public CpGrupoMovimientoDTO getSelectedCpGrupoMovimiento() {
        return selectedCpGrupoMovimiento;
    }

    public void setSelectedCpGrupoMovimiento(
        CpGrupoMovimientoDTO cpGrupoMovimiento) {
        this.selectedCpGrupoMovimiento = cpGrupoMovimiento;
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
