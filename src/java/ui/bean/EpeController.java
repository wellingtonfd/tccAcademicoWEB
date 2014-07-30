package ui.bean;

import entity.Epe;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "epeController")
@ViewScoped
public class EpeController extends AbstractController<Epe> {

    @Inject
    private TipoMaterialController tipoMaterialIdMaterialController;
    @Inject
    private TipoEquipamentoController tipoEquipamentoCollectionController;

    public EpeController() {
        // Inform the Abstract parent controller of the concrete Epe?cap_first Entity
        super(Epe.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        tipoMaterialIdMaterialController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoMaterial controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoMaterialIdMaterial(ActionEvent event) {
        if (this.getSelected() != null && tipoMaterialIdMaterialController.getSelected() == null) {
            tipoMaterialIdMaterialController.setSelected(this.getSelected().getTipoMaterialIdMaterial());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TipoEquipamento entities
     * that are retrieved from Epe?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for TipoEquipamento page
     */
    public String navigateTipoEquipamentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoEquipamento_items", this.getSelected().getTipoEquipamentoCollection());
        }
        return "/entity/tipoEquipamento/index";
    }

}
