/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.factory;

import entity.EstFisico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 * @author Wellington Duarte
 */
@Stateless
public class EstFisicoFacade extends AbstractFacade<EstFisico> {
    @PersistenceContext(unitName = "tccAcademicoWEBPU2")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstFisicoFacade() {
        super(EstFisico.class);
    }

}
