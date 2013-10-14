package org.zathura.cuentas.presentation.backingBeans;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.primefaces.component.selectcheckboxmenu.SelectCheckboxMenu;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.component.selectoneradio.SelectOneRadio;

import org.primefaces.event.DateSelectEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpMovimientoDTO;
import org.zathura.cuentas.personales.dto.MovimientoAplica;
import org.zathura.cuentas.presentation.businessDelegate.BusinessDelegatorView;
import org.zathura.cuentas.utilities.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.swing.text.StyledEditorKit.BoldAction;


/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public class CpMovimientoView {
    private InputText txtDescripcionMovimiento;
    private InputText txtObservaciones;
    private InputText txtIdGrupoMovimiento_CpGrupoMovimiento;
    private InputText txtIdUsuario_CpUsuarios;
    private InputText txtIdMovimiento;
    private InputText txtAnnoAplica;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private Long slctTipoMovimiento;
    private Long  slctGrupoMovimiento;
    private List<SelectItem> listGrupoMovimento;
    private List<String> slctCheckMeses;
    private List<SelectItem> listMeses;
    private List<CpMovimientoDTO> data;
    private List<MovimientoAplica> lstMovAplica;
    private CpMovimientoDTO selectedCpMovimiento;
    private Long gm = 0L;
    private Long annoAplica;
    
    private List<String> items;
    private Map<String,Boolean> checkMap = new HashMap<String,Boolean>();
    private Map<String,Boolean> checkMap2 = new HashMap<String,Boolean>();
    //meses
    private boolean enero;
    private boolean febrero;
    private boolean marzo;
    private boolean abril;
    private boolean mayo;
    private boolean junio;
    private boolean julio;
    private boolean agosto;
    private boolean septiembre;
    private boolean octubre;
    private boolean noviembre;
    private boolean diciembre;
   
     //meses
   // private SelectBooleanCheckbox checkEnero;
   


    public CpMovimientoView() {
        super();
    }
    
    /**
     * Inicia la consulta de los movimientos 
     * @param event
     */
    public void startChanged(ValueChangeEvent event) {
    	try{
	    	if(event.getNewValue() != null || !event.getNewValue().equals("") ){
	    	 annoAplica = new Long(event.getNewValue().toString());
	    	 consultaLista();
	    	}	
	    } catch (Exception e) {
			 FacesUtils.addErrorMessage(e.getMessage());
		}
    }
    
//     public String getSelected() {
//       String result = "";
//        for (checkMap2<String,Boolean> entry : checkMap)) {
//           if (entry.getValue()) {
//                result = result + ", "+entry.getKey();
//            }
//        }
//        return result.length() == 0 ? "" : result.sub string(2);
//     }


    public void rowEventAplica(SelectEvent e){
		try{
     		selectedCpMovimiento = (CpMovimientoDTO) e.getObject();
     		//checkEnero.setDisabled(true);
     		
         } catch (Exception ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
        }
	 }
    
    
    public void controlCheckEnero(ValueChangeEvent event) {  
 	   try{     
 		 Long mesSelected = 1L; //Enero   
 		 boolean tmp = (Boolean)event.getNewValue() ;

 		  if(tmp){ 
 			  action_check_save(mesSelected);
 		   }else{
 			  action_check_delete(mesSelected);
 		  }
           // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
 	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
 	 } catch (Exception ex) {
          FacesUtils.addErrorMessage(ex.getMessage());
          ex.printStackTrace();
      }
 	} 
    
    public void controlCheckFebrero(ValueChangeEvent event) {  
  	   try{     
  		 Long mesSelected = 2L; //Enero   
  		 boolean tmp = (Boolean)event.getNewValue() ;

  		  if(tmp){ 
  			  action_check_save(mesSelected);
  		   }else{
  			  action_check_delete(mesSelected);
  		  }
            // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
  	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
  	 } catch (Exception ex) {
           FacesUtils.addErrorMessage(ex.getMessage());
           ex.printStackTrace();
       }
  	}
    
    public void controlCheckMarzo(ValueChangeEvent event) {  
   	   try{     
   		 Long mesSelected = 3L; //Marzo   
   		 boolean tmp = (Boolean)event.getNewValue() ;

   		  if(tmp){ 
   			  action_check_save(mesSelected);
   		   }else{
   			  action_check_delete(mesSelected);
   		  }
             // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
   	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
   	 } catch (Exception ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
   	}
    
    public void controlCheckAbril(ValueChangeEvent event) {  
    	   try{     
    		 Long mesSelected = 4L; //Abril   
    		 boolean tmp = (Boolean)event.getNewValue() ;

    		  if(tmp){ 
    			  action_check_save(mesSelected);
    		   }else{
    			  action_check_delete(mesSelected);
    		  }
              // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
    	 } catch (Exception ex) {
             FacesUtils.addErrorMessage(ex.getMessage());
             ex.printStackTrace();
         }
    	}

    public void controlCheckMayo(ValueChangeEvent event) {  
 	   try{     
 		 Long mesSelected = 5L; //Mayo   
 		 boolean tmp = (Boolean)event.getNewValue() ;

 		  if(tmp){ 
 			  action_check_save(mesSelected);
 		   }else{
 			  action_check_delete(mesSelected);
 		  }
           // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
 	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
 	 } catch (Exception ex) {
          FacesUtils.addErrorMessage(ex.getMessage());
          ex.printStackTrace();
      }
 	}

    public void controlCheckJunio(ValueChangeEvent event) {  
 	   try{     
 		 Long mesSelected = 6L; // Junio
 		 boolean tmp = (Boolean)event.getNewValue() ;

 		  if(tmp){ 
 			  action_check_save(mesSelected);
 		   }else{
 			  action_check_delete(mesSelected);
 		  }
           // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
 	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
 	 } catch (Exception ex) {
          FacesUtils.addErrorMessage(ex.getMessage());
          ex.printStackTrace();
      }
 	}
   
    public void controlCheckJulio(ValueChangeEvent event) {  
  	   try{     
  		 Long mesSelected = 7L; //Julio
  		 boolean tmp = (Boolean)event.getNewValue() ;

  		  if(tmp){ 
  			  action_check_save(mesSelected);
  		   }else{
  			  action_check_delete(mesSelected);
  		  }
            // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
  	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
  	 } catch (Exception ex) {
           FacesUtils.addErrorMessage(ex.getMessage());
           ex.printStackTrace();
       }
  	} 
 
    public void controlCheckAgosto(ValueChangeEvent event) {  
   	   try{     
   		 Long mesSelected = 8L; //Agosto
   		 boolean tmp = (Boolean)event.getNewValue() ;

   		  if(tmp){ 
   			  action_check_save(mesSelected);
   		   }else{
   			  action_check_delete(mesSelected);
   		  }
             // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
   	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
   	 } catch (Exception ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
   	}
    
    public void controlCheckSeptiembre(ValueChangeEvent event) {  
    	   try{     
    		 Long mesSelected = 9L; //Septiembre
    		 boolean tmp = (Boolean)event.getNewValue() ;

    		  if(tmp){ 
    			  action_check_save(mesSelected);
    		   }else{
    			  action_check_delete(mesSelected);
    		  }
              // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
    	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
    	 } catch (Exception ex) {
             FacesUtils.addErrorMessage(ex.getMessage());
             ex.printStackTrace();
         }
   	}
    
    public void controlCheckOctubre(ValueChangeEvent event) {  
 	   try{     
 		 Long mesSelected = 10L; //Octubre
 		 boolean tmp = (Boolean)event.getNewValue() ;

 		  if(tmp){ 
 			  action_check_save(mesSelected);
 		   }else{
 			  action_check_delete(mesSelected);
 		  }
           // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
 	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
 	 } catch (Exception ex) {
          FacesUtils.addErrorMessage(ex.getMessage());
          ex.printStackTrace();
      }
	}
   
    public void controlCheckNoviembre(ValueChangeEvent event) {  
  	   try{     
  		 Long mesSelected = 11L; //Noviembre
  		 boolean tmp = (Boolean)event.getNewValue() ;

  		  if(tmp){ 
  			  action_check_save(mesSelected);
  		   }else{
  			  action_check_delete(mesSelected);
  		  }
            // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
  	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
  	 } catch (Exception ex) {
           FacesUtils.addErrorMessage(ex.getMessage());
           ex.printStackTrace();
       }
 	}
    
    public void controlCheckDiciembre(ValueChangeEvent event) {  
   	   try{     
   		 Long mesSelected = 12L; //Diciembre
   		 boolean tmp = (Boolean)event.getNewValue() ;

   		  if(tmp){ 
   			  action_check_save(mesSelected);
   		   }else{
   			  action_check_delete(mesSelected);
   		  }
             // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
   	       // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
   	 } catch (Exception ex) {
            FacesUtils.addErrorMessage(ex.getMessage());
            ex.printStackTrace();
        }
  	} 
    
    public void rowEventListener(RowEditEvent e) {
    	
        try {
            CpMovimientoDTO cpMovimientoDTO = (CpMovimientoDTO) e.getObject();

            if (txtDescripcionMovimiento == null) {
                txtDescripcionMovimiento = new InputText();
            }


            if (txtObservaciones == null) {
                txtObservaciones = new InputText();
            }

            txtObservaciones.setValue(cpMovimientoDTO.getObservaciones());

            if (txtIdGrupoMovimiento_CpGrupoMovimiento == null) {
                txtIdGrupoMovimiento_CpGrupoMovimiento = new InputText();
            }

            txtIdGrupoMovimiento_CpGrupoMovimiento.setValue(cpMovimientoDTO.getIdGrupoMovimiento_CpGrupoMovimiento());

            if (txtIdUsuario_CpUsuarios == null) {
                txtIdUsuario_CpUsuarios = new InputText();
            }

            txtIdUsuario_CpUsuarios.setValue(cpMovimientoDTO.getIdUsuario_CpUsuarios());

            if (txtIdMovimiento == null) {
                txtIdMovimiento = new InputText();
            }

            txtIdMovimiento.setValue(cpMovimientoDTO.getIdMovimiento());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public String action_clear() {
        if (txtDescripcionMovimiento != null) {
            txtDescripcionMovimiento.setValue(null);
            txtDescripcionMovimiento.setDisabled(true);
        }

        if (txtObservaciones != null) {
            txtObservaciones.setValue(null);
            txtObservaciones.setDisabled(true);
        }

        if (txtIdGrupoMovimiento_CpGrupoMovimiento != null) {
            txtIdGrupoMovimiento_CpGrupoMovimiento.setValue(null);
            txtIdGrupoMovimiento_CpGrupoMovimiento.setDisabled(true);
        }

        if (txtIdUsuario_CpUsuarios != null) {
            txtIdUsuario_CpUsuarios.setValue(null);
            txtIdUsuario_CpUsuarios.setDisabled(true);
        }

        if (txtIdMovimiento != null) {
            txtIdMovimiento.setValue(null);
            txtIdMovimiento.setDisabled(false);
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
        CpMovimiento entity = null;

        try {
            Long idMovimiento = new Long(txtIdMovimiento.getValue().toString());
            entity = BusinessDelegatorView.getCpMovimiento(idMovimiento);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtDescripcionMovimiento.setDisabled(false);
            txtObservaciones.setDisabled(false);
            txtIdGrupoMovimiento_CpGrupoMovimiento.setDisabled(false);
            txtIdUsuario_CpUsuarios.setDisabled(false);
            txtIdMovimiento.setDisabled(false);
            btnSave.setDisabled(false);
            btnDelete.setDisabled(true);
            btnModify.setDisabled(true);
            btnClear.setDisabled(false);
        } else {
            txtDescripcionMovimiento.setValue(entity.getDescripcionMovimiento());
            txtDescripcionMovimiento.setDisabled(false);
            txtObservaciones.setValue(entity.getObservaciones());
            txtObservaciones.setDisabled(false);
            txtIdGrupoMovimiento_CpGrupoMovimiento.setValue(entity.getCpGrupoMovimiento()
                                                                  .getIdGrupoMovimiento());
            txtIdGrupoMovimiento_CpGrupoMovimiento.setDisabled(false);
            txtIdUsuario_CpUsuarios.setValue(entity.getCpUsuarios()
                                                   .getIdUsuario());
            txtIdUsuario_CpUsuarios.setDisabled(false);
            txtIdMovimiento.setValue(entity.getIdMovimiento());
            txtIdMovimiento.setDisabled(true);
            btnSave.setDisabled(true);
            btnDelete.setDisabled(false);
            btnModify.setDisabled(false);
            btnClear.setDisabled(false);
        }
    }

    public String action_save() {
        try {
            BusinessDelegatorView.saveCpMovimiento(FacesUtils.checkString(
                    txtDescripcionMovimiento),
                FacesUtils.checkLong(txtIdMovimiento),
                FacesUtils.checkString(txtObservaciones),
                FacesUtils.checkLong(txtIdGrupoMovimiento_CpGrupoMovimiento),
                FacesUtils.checkLong(txtIdUsuario_CpUsuarios));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }
   
    public String action_save_withoutId() {
    	
        try {
               BusinessDelegatorView.saveCpMovimientoWithoutId(FacesUtils.checkString(
                 txtDescripcionMovimiento),
                "N",
                slctGrupoMovimiento,
                11L);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    } 

    public String action_delete() {
        try {
            BusinessDelegatorView.deleteCpMovimiento(FacesUtils.checkLong(
                    txtIdMovimiento));
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            BusinessDelegatorView.updateCpMovimiento(FacesUtils.checkString(
                    txtDescripcionMovimiento),
                FacesUtils.checkLong(txtIdMovimiento),
                FacesUtils.checkString(txtObservaciones),
                FacesUtils.checkLong(txtIdGrupoMovimiento_CpGrupoMovimiento),
                FacesUtils.checkLong(txtIdUsuario_CpUsuarios));
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
            if (txtIdMovimiento == null) {
                txtIdMovimiento = new InputText();
            }

            txtIdMovimiento.setValue(selectedCpMovimiento.getIdMovimiento());

            BusinessDelegatorView.deleteCpMovimiento(FacesUtils.checkLong(
                    txtIdMovimiento));
            data.remove(selectedCpMovimiento);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modifyWitDTO(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception {
        try {
            BusinessDelegatorView.updateCpMovimiento(descripcionMovimiento,
                idMovimiento, observaciones,
                idGrupoMovimiento_CpGrupoMovimiento, idUsuario_CpUsuarios);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CpMovimientoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDescripcionMovimiento() {
        return txtDescripcionMovimiento;
    }

    public void setTxtDescripcionMovimiento(InputText txtDescripcionMovimiento) {
        this.txtDescripcionMovimiento = txtDescripcionMovimiento;
    }

    public InputText getTxtObservaciones() {
        return txtObservaciones;
    }

    public void setTxtObservaciones(InputText txtObservaciones) {
        this.txtObservaciones = txtObservaciones;
    }

    public InputText getTxtIdGrupoMovimiento_CpGrupoMovimiento() {
        return txtIdGrupoMovimiento_CpGrupoMovimiento;
    }

    public void setTxtIdGrupoMovimiento_CpGrupoMovimiento(
        InputText txtIdGrupoMovimiento_CpGrupoMovimiento) {
        this.txtIdGrupoMovimiento_CpGrupoMovimiento = txtIdGrupoMovimiento_CpGrupoMovimiento;
    }

    public InputText getTxtIdUsuario_CpUsuarios() {
        return txtIdUsuario_CpUsuarios;
    }

    public void setTxtIdUsuario_CpUsuarios(InputText txtIdUsuario_CpUsuarios) {
        this.txtIdUsuario_CpUsuarios = txtIdUsuario_CpUsuarios;
    }

    public InputText getTxtIdMovimiento() {
        return txtIdMovimiento;
    }

    public void setTxtIdMovimiento(InputText txtIdMovimiento) {
        this.txtIdMovimiento = txtIdMovimiento;
    }

    public List<CpMovimientoDTO> getData() {
        try {
            if (data == null) {
                data = BusinessDelegatorView.getDataCpMovimiento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CpMovimientoDTO> cpMovimientoDTO) {
        this.data = cpMovimientoDTO;
    }

    public CpMovimientoDTO getSelectedCpMovimiento() {
        return selectedCpMovimiento;
    }

    public void setSelectedCpMovimiento(CpMovimientoDTO cpMovimiento) {
        this.selectedCpMovimiento = cpMovimiento;
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

	
	public Long getSlctTipoMovimiento() {
		return slctTipoMovimiento;
	}

	public void setSlctTipoMovimiento(Long slctTipoMovimiento) {
		this.slctTipoMovimiento = slctTipoMovimiento;
	}

	public Long getSlctGrupoMovimiento() {
		return slctGrupoMovimiento;
	}

	public void setSlctGrupoMovimiento(Long slctGrupoMovimiento) {
		this.slctGrupoMovimiento = slctGrupoMovimiento;
	}
   public void listener_grupoMovimiento(){
	  // gm = Integer.valueOf(this.getSlctTipoMovimiento()).intValue();
	  gm = this.getSlctTipoMovimiento();
   }
	public List<SelectItem> getListGrupoMovimento() {
   	 try {
			Object[] arr={"cpTipoMovimiento",false,gm,"="};
			List<CpGrupoMovimiento> lista=BusinessDelegatorView.findByCriteriaInCpGrupoMovimiento(arr, null, null) ;
			listGrupoMovimento=new ArrayList<SelectItem>();
			listGrupoMovimento.add(new SelectItem("-1", "[SELECCIONE..]"));
			for (CpGrupoMovimiento cpGrupoMovimiento : lista) {
				listGrupoMovimento.add(new SelectItem(cpGrupoMovimiento.getIdGrupoMovimiento(),cpGrupoMovimiento.getDescripcion()));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
						
		return listGrupoMovimento;
	}

	
	public List<SelectItem> getListMeses() {
		 try {
			 listMeses=new ArrayList<SelectItem>();
			 listMeses.add(new SelectItem(1,"ENERO"));
			 listMeses.add(new SelectItem(2,"FEBRERO"));
			 listMeses.add(new SelectItem(3,"MARZO"));
			 listMeses.add(new SelectItem(4,"ABRIL"));
			 listMeses.add(new SelectItem(5,"MAYO"));
			 listMeses.add(new SelectItem(6,"JUNIO"));
			 listMeses.add(new SelectItem(7,"JULIO"));
			 listMeses.add(new SelectItem(8,"AGOSTO"));
			 listMeses.add(new SelectItem(9,"SEPTIEMBRE"));
			 listMeses.add(new SelectItem(10,"OCTUBRE"));
			 listMeses.add(new SelectItem(11,"NOVIEMBRE"));
			 listMeses.add(new SelectItem(12,"DICIEMBRE"));
											
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return listMeses;
	}

	public void setListMeses(List<SelectItem> listMeses) {
		this.listMeses = listMeses;
	}

	public void setListGrupoMovimento(List<SelectItem> listGrupoMovimento) {
		this.listGrupoMovimento = listGrupoMovimento;
	}

	public List<String> getSlctCheckMeses() {
		return slctCheckMeses;
	}

	public void setSlctCheckMeses(List<String> slctCheckMeses) {
		this.slctCheckMeses = slctCheckMeses;
	}

	public InputText getTxtAnnoAplica() {
		return txtAnnoAplica;
	}

	public void setTxtAnnoAplica(InputText txtAnnoAplica) {
		this.txtAnnoAplica = txtAnnoAplica;
	}

	public boolean isEnero() {
		return enero;
	}

	public void setEnero(boolean enero) {
		this.enero = enero;
	}

	public boolean isFebrero() {
		return febrero;
	}

	public void setFebrero(boolean febrero) {
		this.febrero = febrero;
	}

	public Long getAnnoAplica() {
		return annoAplica;
	}

	public void setAnnoAplica(Long annoAplica) {
		this.annoAplica = annoAplica;
	}

	public boolean isMarzo() {
		return marzo;
	}

	public void setMarzo(boolean marzo) {
		this.marzo = marzo;
	}

	public boolean isAbril() {
		return abril;
	}

	public void setAbril(boolean abril) {
		this.abril = abril;
	}

	public boolean isMayo() {
		return mayo;
	}

	public void setMayo(boolean mayo) {
		this.mayo = mayo;
	}

	public boolean isJunio() {
		return junio;
	}

	public void setJunio(boolean junio) {
		this.junio = junio;
	}

	public boolean isJulio() {
		return julio;
	}

	public void setJulio(boolean julio) {
		this.julio = julio;
	}

	public boolean isAgosto() {
		return agosto;
	}

	public void setAgosto(boolean agosto) {
		this.agosto = agosto;
	}

	public boolean isSeptiembre() {
		return septiembre;
	}

	public void setSeptiembre(boolean septiembre) {
		this.septiembre = septiembre;
	}

	public boolean isOctubre() {
		return octubre;
	}

	public void setOctubre(boolean octubre) {
		this.octubre = octubre;
	}

	public boolean isNoviembre() {
		return noviembre;
	}

	public void setNoviembre(boolean noviembre) {
		this.noviembre = noviembre;
	}

	public boolean isDiciembre() {
		return diciembre;
	}

	public void setDiciembre(boolean diciembre) {
		this.diciembre = diciembre;
	}
	
	
   
//	public SelectBooleanCheckbox getCheckEnero() {
//		return checkEnero;
//	}
//
//	public void setCheckEnero(SelectBooleanCheckbox checkEnero) {
//		this.checkEnero = checkEnero;
//	}

	public Long numeroMes(){    
			Long mes = 0L; 
			if(enero)
		    	mes=1L;
		    if(febrero)
		    	mes=2L;
		    if(marzo)
		    	mes=3L;
		    if(abril)
		    	mes=4L;
		    if(mayo)
		    	mes=5L;
		    if(junio)
		    	mes=6L;
		    if(julio)
		    	mes=7L;
		    if(agosto)
		    	mes=8L;
		    if(septiembre)
		    	mes=9L;
			if(octubre)
		    	mes=10L;
		    if(noviembre)
		    	mes=11L;
		    if(diciembre) 
		    	mes=12L;   
		  return mes;
	} 
	
	public String action_check_save(Long mesSelected) {  
	  try{     
	 	BusinessDelegatorView.saveCpDetalleMovimientoWithOutId(
	 		annoAplica, new Date(),
	 		mesSelected,
	        "I",
	         null,
	         null,
	         null,
	         selectedCpMovimiento.getIdMovimiento());
	      // FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
	      // FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary)); 
	   } catch (Exception ex) {
	       FacesUtils.addErrorMessage(ex.getMessage());
	      
	   }
	 return "";
	}   

	public String action_check_delete(Long mesSelected){
		
  	   try {
  		 Object[] arr={"cpMovimiento",false,selectedCpMovimiento.getIdMovimiento(),"=",
			      "anno",false,annoAplica,"=",
			      "mes",false,mesSelected,"="};
	
		  List<CpDetalleMovimiento> lista = new ArrayList<CpDetalleMovimiento>();
		  lista=BusinessDelegatorView.findByCriteriaInCpDetalleMovimiento(arr, null, null) ;
		  for (CpDetalleMovimiento cpDetalleMovimiento : lista) {
			  BusinessDelegatorView.deleteCpDetalleMovimiento(cpDetalleMovimiento.getIdDetalleMovimiento());
		  }
		  
		} catch (Exception e) {
			 FacesUtils.addErrorMessage(e.getMessage());
		}
		return "";
	}

    public void consultaLista(){
    	   lstMovAplica = new ArrayList<MovimientoAplica>();
    		  try{	
    		   for (CpMovimientoDTO cpMovimientoDTO : this.getData()) {
    			   MovimientoAplica movAplica = new MovimientoAplica();
    			   movAplica.setIdMovimiento(cpMovimientoDTO.getIdMovimiento());
    			   movAplica.setDescripcionMovimiento(cpMovimientoDTO.getDescripcionMovimiento());
    			   movAplica.setIdGrupoMovimiento_CpGrupoMovimiento(cpMovimientoDTO.getIdGrupoMovimiento_CpGrupoMovimiento());
    			   movAplica.setDescripcionGrupo(cpMovimientoDTO.getDescripcionGrupo());
    			   movAplica.setIdUsuario_CpUsuarios(cpMovimientoDTO.getIdUsuario_CpUsuarios());
    			   movAplica.setObservaciones(cpMovimientoDTO.getObservaciones());
    			   
    		  			   
    			   for(Long mes=1L;mes<=12;mes++){
    		    		 Object[] arr={"cpMovimiento",false,cpMovimientoDTO.getIdMovimiento(),"=",
    						      "anno",false,annoAplica,"=",
    						      "mes",false,mes,"="};
    		    		 List<CpDetalleMovimiento> lista = new ArrayList<CpDetalleMovimiento>();
    					 lista=BusinessDelegatorView.findByCriteriaInCpDetalleMovimiento(arr, null, null) ;
    					 if(mes == 1L){
    					  if(lista.size()>0){ 
    						  movAplica.setEnero(true);
    						} else {
    						  movAplica.setEnero(false);
    					  }
    					 }
    					 if(mes == 2L){
    						  if(lista.size()>0){ 
    							  movAplica.setFebrero(true);
    							} else {
    	                          movAplica.setFebrero(false);
    						  }
    					 } 
    					 if(mes == 3L){
    						  if(lista.size()>0){ 
    							  movAplica.setMarzo(true);
    							} else {
    	                         movAplica.setMarzo(false);
    						  }
    					 }
    					 if(mes == 4L){
    						  if(lista.size()>0){ 
    							movAplica.setAbril(true);
    							} else {
    	                        movAplica.setAbril(false);
    						  }
    					 }
    					 if(mes == 5L){
    						  if(lista.size()>0){ 
    							movAplica.setMayo(true);
    							} else {
    	                        movAplica.setMayo(false);
    						  }
    					 }
    					 if(mes == 6L){
    						  if(lista.size()>0){ 
    							movAplica.setJunio(true);
    							} else {
    	                       movAplica.setJunio(false);
    						  }
    					 }
    					 if(mes == 7L){
    						  if(lista.size()>0){ 
    						 	movAplica.setJulio(true);
    							} else {
    	                       movAplica.setJulio(false);
    						  }
    					 }
    					 if(mes == 8L){
    						  if(lista.size()>0){ 
    							movAplica.setAgosto(true);
    							} else {
    	                      movAplica.setAgosto(false);
    						  }
    					 }
    					 if(mes == 9L){
    						  if(lista.size()>0){ 
    							movAplica.setSeptiembre(true);
    							} else {
    	                     movAplica.setSeptiembre(false);
    						  }
    					 }
    					 if(mes == 10L){
    						  if(lista.size()>0){ 
    							movAplica.setOctubre(true);
    							} else {
    	                     movAplica.setOctubre(false);
    						  }
    					 }
    					 if(mes == 11L){
    						  if(lista.size()>0){ 
    							movAplica.setNoviembre(true);
    							} else {
    	                     movAplica.setNoviembre(false);
    						  }
    					 }
    					 if(mes == 12L){
    						  if(lista.size()>0){ 
    							movAplica.setDiciembre(true);
    							} else {
    	                     movAplica.setDiciembre(false);
    						  }
    					 }
    		    		}
    			   lstMovAplica.add(movAplica);
    		   } 
    		  } catch (Exception e) {
    				 FacesUtils.addErrorMessage(e.getMessage());
    		  }  	
    	
    }	

	public List<MovimientoAplica> getLstMovAplica() {
		return lstMovAplica;
	}

	public void setLstMovAplica(List<MovimientoAplica> lstMovAplica) {
		this.lstMovAplica = lstMovAplica;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Map<String, Boolean> getCheckMap() {
		return checkMap;
	}

	public void setCheckMap(Map<String, Boolean> checkMap) {
		this.checkMap = checkMap;
	}
	
	
	
}
