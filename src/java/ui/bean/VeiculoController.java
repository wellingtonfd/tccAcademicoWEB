package ui.bean;

import entity.Veiculo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "veiculoController")
@ViewScoped
public class VeiculoController extends AbstractController<Veiculo> {

    @Inject
    private TipoEquipamentoController tipoEquipamentoCollectionController;
    @Inject
    private CombustivelController idCombustivelController;

    public VeiculoController() {
        // Inform the Abstract parent controller of the concrete Veiculo?cap_first Entity
        super(Veiculo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idCombustivelController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of TipoEquipamento entities
     * that are retrieved from Veiculo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for TipoEquipamento page
     */
    public String navigateTipoEquipamentoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("TipoEquipamento_items", this.getSelected().getTipoEquipamentoCollection());
        }
        return "/entities/tipoEquipamento/index";
    }

    /**
     * Sets the "selected" attribute of the Combustivel controller in order to
     * display its data in a dialog. This is reusing existing the existing View
     * dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCombustivel(ActionEvent event) {
        if (this.getSelected() != null && idCombustivelController.getSelected() == null) {
            idCombustivelController.setSelected(this.getSelected().getIdCombustivel());
        }
    }
}
