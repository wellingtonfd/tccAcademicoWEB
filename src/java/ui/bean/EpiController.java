package ui.bean;

import entity.Epi;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "epiController")
@ViewScoped
public class EpiController extends AbstractController<Epi> {

    @Inject
    private TipoMaterialController idMaterialController;
    @Inject
    private TipoEquipamentoController tipoEquipamentoCollectionController;

    public EpiController() {
        // Inform the Abstract parent controller of the concrete Epi?cap_first Entity
        super(Epi.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idMaterialController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TipoMaterial controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdMaterial(ActionEvent event) {
        if (this.getSelected() != null && idMaterialController.getSelected() == null) {
            idMaterialController.setSelected(this.getSelected().getIdMaterial());
        }
    }

    /**
     * Sets the "items" attribute with a collection of TipoEquipamento entities
     * that are retrieved from Epi?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for TipoEquipamento page
     */
    public String navigateTipoEquipamentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoEquipamento_items", this.getSelected().getTipoEquipamentoCollection());
        }
        return "/entities/tipoEquipamento/index";
    }

}
