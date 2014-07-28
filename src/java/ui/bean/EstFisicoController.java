package ui.bean;

import entity.EstFisico;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;

@Named(value = "estFisicoController")
@ViewScoped
public class EstFisicoController extends AbstractController<EstFisico> {

    public EstFisicoController() {
        // Inform the Abstract parent controller of the concrete EstFisico?cap_first Entity
        super(EstFisico.class);
    }

}
