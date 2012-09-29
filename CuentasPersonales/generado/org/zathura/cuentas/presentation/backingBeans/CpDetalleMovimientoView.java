package org.zathura.cuentas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.RowEditEvent;

import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpDetalleMovimientoDTO;
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
public class CpDetalleMovimientoView {
    private InputText txtAnno;
    private InputText txtMes;
    private InputText txtObservaciones;
    private InputText txtPendiente;
    private InputText txtValorMovimiento;
    private InputText txtValorPago;
    private InputText txtIdMovimiento_CpMovimiento;
    private InputText txtIdDetalleMovimiento;
    private Calendar txtFehcaRegistro;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CpDetalleMovimientoDTO> data;
    private CpDetalleMovimientoDTO selectedCpDetalleMovimiento;

    public CpDetalleMovimientoView() {
        super();
    }

    public void rowEventListener(RowEditEvent e) {
        try {
            CpDetalleMovimientoDTO cpDetalleMovimientoDTO = (CpDetalleMovimientoDTO) e.getObject();

            if (txtAnno == null) {
                txtAnno = new InputText();
            }

            txtAnno.setValue(cpDetalleMovimientoDTO.getAnno());

            if (txtMes == null) {
                txtMes = new InputText();
            }

            txtMes.setValue(cpDetalleMovimientoDTO.getMes());

            if (txtObservaciones == null) {
                txtObservaciones = new InputText();
            }

            txtObservaciones.setValue(cpDetalleMovimientoDTO.getObservaciones());

            if (txtPendiente == null) {
                txtPendiente = new InputText();
            }

            txtPendiente.setValue(cpDetalleMovimientoDTO.getPendiente());

            if (txtValorMovimiento == null) {
                txtValorMovimiento = new InputText();
            }

            txtValorMovimiento.setValue(cpDetalleMovimientoDTO.getValorMovimiento());

            if (txtValorPago == null) {
                txtValorPago = new InputText();
            }

            txtValorPago.setValue(cpDetalleMovimientoDTO.getValorPago());

            if (txtIdMovimiento_CpMovimiento == null) {
                txtIdMovimiento_CpMovimiento = new InputText();
            }

            txtIdMovimiento_CpMovimiento.setValue(cpDetalleMovimientoDTO.getIdMovimiento_CpMovimiento());

            if (txtIdDetalleMovimiento == null) {
                txtIdDetalleMovimiento = new InputText();
            }

            txtIdDetalleMovimiento.setValue(cpDetalleMovimientoDTO.getIdDetalleMovimiento());

            if (txtFehcaRegistro == null) {
                txtFehcaRegistro = new Calendar();
            }

            txtFehcaRegistro.setValue(cpDetalleMovimientoDTO.getFehcaRegistro());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtAnno != null) {
            txtAnno.setValue(null);
            txtAnno.setDisabled(true);
        }

        if (txtMes != null) {
            txtMes.setValue(null);
            txtMes.setDisabled(true);
        }

        if (txtObservaciones != null) {
            txtObservaciones.setValue(null);
            txtObservaciones.setDisabled(true);
        }

        if (txtPendiente != null) {
            txtPendiente.setValue(null);
            txtPendiente.setDisabled(true);
        }

        if (txtValorMovimiento != null) {
            txtValorMovimiento.setValue(null);
            txtValorMovimiento.setDisabled(true);
        }

        if (txtValorPago != null) {
            txtValorPago.setValue(null);
            txtValorPago.setDisabled(true);
        }

        if (txtIdMovimiento_CpMovimiento != null) {
            txtIdMovimiento_CpMovimiento.setValue(null);
            txtIdMovimiento_CpMovimiento.setDisabled(true);
        }

        if (txtFehcaRegistro != null) {
            txtFehcaRegistro.setValue(null);
            txtFehcaRegistro.setDisabled(true);
        }

        if (txtIdDetalleMovimiento != null) {
            txtIdDetalleMovimiento.setValue(null);
            txtIdDetalleMovimiento.setDisabled(false);
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

    public void listener_txtFehcaRegistro(DateSelectEvent dse) {
        Date inputDate = (Date) txtFehcaRegistro.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Fecha Seleccionada " +
                dateFormat.format(dse.getDate())));
    }

    public void listener_txtId() {
        CpDetalleMovimiento entity = null;

        try {
            Long idDetalleMovimiento = new Long(txtIdDetalleMovimiento.getValue()
                                                                      .toString());
            entity = BusinessDelegatorView.getCpDetalleMovimiento(idDetalleMovimiento);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtAnno.setDisabled(false);
            txtMes.setDisabled(false);
            txtObservaciones.setDisabled(false);
            txtPendiente.setDisabled(false);
            txtValorMovimiento.setDisabled(false);
            txtValorPago.setDisabled(false);
            txtIdMovimiento_CpMovimiento.setDisabled(false);
            txtFehcaRegistro.setDisabled(false);
            txtIdDetalleMovimiento.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtAnno.setValue(entity.getAnno());
            txtAnno.setDisabled(false);
            txtFehcaRegistro.setValue(entity.getFehcaRegistro());
            txtFehcaRegistro.setDisabled(false);
            txtMes.setValue(entity.getMes());
            txtMes.setDisabled(false);
            txtObservaciones.setValue(entity.getObservaciones());
            txtObservaciones.setDisabled(false);
            txtPendiente.setValue(entity.getPendiente());
            txtPendiente.setDisabled(false);
            txtValorMovimiento.setValue(entity.getValorMovimiento());
            txtValorMovimiento.setDisabled(false);
            txtValorPago.setValue(entity.getValorPago());
            txtValorPago.setDisabled(false);
            txtIdMovimiento_CpMovimiento.setValue(entity.getCpMovimiento()
                                                        .getIdMovimiento());
            txtIdMovimiento_CpMovimiento.setDisabled(false);
            txtIdDetalleMovimiento.setValue(entity.getIdDetalleMovimiento());
            txtIdDetalleMovimiento.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            BusinessDelegatorView.saveCpDetalleMovimiento(FacesUtils.checkLong(
                    txtAnno), FacesUtils.checkDate(txtFehcaRegistro),
                FacesUtils.checkLong(txtIdDetalleMovimiento),
                FacesUtils.checkLong(txtMes),
                FacesUtils.checkString(txtObservaciones),
                FacesUtils.checkString(txtPendiente),
                FacesUtils.checkLong(txtValorMovimiento),
                FacesUtils.checkLong(txtValorPago),
                FacesUtils.checkLong(txtIdMovimiento_CpMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete() {
        try {
            BusinessDelegatorView.deleteCpDetalleMovimiento(FacesUtils.checkLong(
                    txtIdDetalleMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            BusinessDelegatorView.updateCpDetalleMovimiento(FacesUtils.checkLong(
                    txtAnno), FacesUtils.checkDate(txtFehcaRegistro),
                FacesUtils.checkLong(txtIdDetalleMovimiento),
                FacesUtils.checkLong(txtMes),
                FacesUtils.checkString(txtObservaciones),
                FacesUtils.checkString(txtPendiente),
                FacesUtils.checkLong(txtValorMovimiento),
                FacesUtils.checkLong(txtValorPago),
                FacesUtils.checkLong(txtIdMovimiento_CpMovimiento));
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
            if (txtIdDetalleMovimiento == null) {
                txtIdDetalleMovimiento = new InputText();
            }

            txtIdDetalleMovimiento.setValue(selectedCpDetalleMovimiento.getIdDetalleMovimiento());

            BusinessDelegatorView.deleteCpDetalleMovimiento(FacesUtils.checkLong(
                    txtIdDetalleMovimiento));
            data.remove(selectedCpDetalleMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception {
        try {
            BusinessDelegatorView.updateCpDetalleMovimiento(anno,
                fehcaRegistro, idDetalleMovimiento, mes, observaciones,
                pendiente, valorMovimiento, valorPago, idMovimiento_CpMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CpDetalleMovimientoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtAnno() {
        return txtAnno;
    }

    public void setTxtAnno(InputText txtAnno) {
        this.txtAnno = txtAnno;
    }

    public InputText getTxtMes() {
        return txtMes;
    }

    public void setTxtMes(InputText txtMes) {
        this.txtMes = txtMes;
    }

    public InputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(InputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    public InputText getTxtPendiente() {
        return txtPendiente;
    }

    public void setTxtPendiente(InputText txtPendiente) {
        this.txtPendiente = txtPendiente;
    }

    public InputText getTxtValorMovimiento() {
        return txtValorMovimiento;
    }

    public void setTxtValorMovimiento(InputText txtValorMovimiento) {
        this.txtValorMovimiento = txtValorMovimiento;
    }

    public InputText getTxtValorPago() {
        return txtValorPago;
    }

    public void setTxtValorPago(InputText txtValorPago) {
        this.txtValorPago = txtValorPago;
    }

    public InputText getTxtIdMovimiento_CpMovimiento() {
        return txtIdMovimiento_CpMovimiento;
    }

    public void setTxtIdMovimiento_CpMovimiento(
        InputText txtIdMovimiento_CpMovimiento) {
        this.txtIdMovimiento_CpMovimiento = txtIdMovimiento_CpMovimiento;
    }

    public Calendar getTxtFehcaRegistro() {
        return txtFehcaRegistro;
    }

    public void setTxtFehcaRegistro(Calendar txtFehcaRegistro) {
        this.txtFehcaRegistro = txtFehcaRegistro;
    }

    public InputText getTxtIdDetalleMovimiento() {
        return txtIdDetalleMovimiento;
    }

    public void setTxtIdDetalleMovimiento(InputText txtIdDetalleMovimiento) {
        this.txtIdDetalleMovimiento = txtIdDetalleMovimiento;
    }

    public List<CpDetalleMovimientoDTO> getData() {
        try {
            if (data == null) {
                data = BusinessDelegatorView.getDataCpDetalleMovimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CpDetalleMovimientoDTO> cpDetalleMovimientoDTO) {
        this.data = cpDetalleMovimientoDTO;
    }

    public CpDetalleMovimientoDTO getSelectedCpDetalleMovimiento() {
        return selectedCpDetalleMovimiento;
    }

    public void setSelectedCpDetalleMovimiento(
        CpDetalleMovimientoDTO cpDetalleMovimiento) {
        this.selectedCpDetalleMovimiento = cpDetalleMovimiento;
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
