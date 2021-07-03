/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kobitxu.patronvisitor;

import com.kobitxu.patronvisitor.domain.EmployeePay;
import com.kobitxu.patronvisitor.domain.Project;
import com.kobitxu.patronvisitor.impl.CostProjectVisitor;
import com.kobitxu.patronvisitor.impl.PaymentProjectVisitor;
import com.kobitxu.patronvisitor.impl.PriceProjectVisitor;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author joseph
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Project project = null;
        try {
            JAXBContext context
                    = JAXBContext.newInstance(Project.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            project = (Project) unmarshaller
                    .unmarshal(Aplicacion.class.getClassLoader()
                            .getResourceAsStream("Project.xml"));
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //Obtain the total cost of the project  
        CostProjectVisitor costVisitor = new CostProjectVisitor();
        project.accept(costVisitor);
        double cost = costVisitor.getResult().doubleValue();
        System.out.println("Total cost > " + cost);

        //Get the sale price of the project  
        PriceProjectVisitor priceVisitor = new PriceProjectVisitor();
        project.accept(priceVisitor);
        double price = priceVisitor.getResult().doubleValue();
        System.out.println("Total price > " + price);
        System.out.println("Total gain > " + (price - cost));

        //Show the total to pay per employee 
        System.out.println("\n:::::::: Pay the workers :::::::");
        PaymentProjectVisitor paymentVisitor
                = new PaymentProjectVisitor();
        project.accept(paymentVisitor);
        List<EmployeePay> result = paymentVisitor.getResult();
        result.forEach((pay) -> {
            System.out.println(pay.getEmployeeName() + " > " + pay.getTotalPay());
        });
    }
}
