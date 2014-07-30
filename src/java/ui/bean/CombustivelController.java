package ui.bean;

import entity.Combustivel;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "combustivelController")
@ViewScoped
public class CombustivelController extends AbstractController<Combustivel> {

    @Inject
    private VeiculoController veiculoCollectionController;

    public CombustivelController() {
        // Inform the Abstract parent controller of the concrete Combustivel?cap_first Entity
        super(Combustivel.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
    }

    /**
     * Sets the "items" attribute with a collection of Veiculo entities that are
     * retrieved from Combustivel?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Veiculo page
     */
    public String navigateVeiculoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Veiculo_items", this.getSelected().getVeiculoCollection());
        }
        return "/entity/veiculo/index";
    }

}
