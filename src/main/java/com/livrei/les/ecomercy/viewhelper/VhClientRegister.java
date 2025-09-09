package com.livrei.les.ecomercy.viewhelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.web.servlet.ModelAndView;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.Address;
import com.livrei.les.ecomercy.domain.CreditCard;
import com.livrei.les.ecomercy.domain.EntityDomain;
import com.livrei.les.ecomercy.domain.Phone;
import com.livrei.les.ecomercy.domain.enums.AddressType;
import com.livrei.les.ecomercy.domain.Client;
import static com.livrei.les.ecomercy.utils.RequestUtils.*;
import jakarta.servlet.http.HttpServletRequest;

public class VhClientRegister implements IViewHelper{
	@Override
	public EntityDomain getEntidade(HttpServletRequest request) {
		
		
		Client client = new Client();
	    // Personal Infos
	    client.setFullname(getSafeParam(request, "fullname"));
	    client.setCpf(getSafeParam(request, "cpf").replaceAll("[^\\d]", ""));	    
	    client.setBirthDate(getDateParam(request, "birth"));
	    client.setGender(getSafeParam(request,"gender"));
	    
	    //Phones 
	    
	    Phone phone = new Phone();
	    phone.setNumber(getSafeParam(request,"phone"));
	    phone.setType(getSafeParam(request,"contact-type"));
	    
	    client.setPhone(phone);

	    //Address
	    Address address = new Address();
	    address.setCep(request.getParameter("cep"));
	    address.setResidenceType(request.getParameter("residence-type"));
	    address.setName(request.getParameter("street"));
	    address.setNumber(request.getParameter("number"));
	    address.setComplement(request.getParameter("complement"));
	    address.setCity(request.getParameter("city"));
	    address.setState(request.getParameter("state"));
	    address.setByname(request.getParameter("address-name"));
	    address.setObservation(request.getParameter("address-observations"));
	    
	    
	    address.setTipos(Set.of(
	    	    AddressType.CHARGE,
	    	    AddressType.DELIVERY));
	    
	    List<Address> addressList = new ArrayList<>();
	    
	    addressList.add(address);
	    client.setAddresses(addressList);

	    //Credit Card
	    CreditCard card = new CreditCard();
	    card.setPrintedName(request.getParameter("cardName"));
	    card.setNumber(request.getParameter("cardNumber"));
	    card.setSecurityCode(request.getParameter("security-code"));
	    card.setBrand(request.getParameter("card-brand"));
	    
	    
	    List<CreditCard> creditCardList = new ArrayList<>();
	    
	    creditCardList.add(card);
	    client.setCards(creditCardList);

	    // Access info
	    client.setEmail(request.getParameter("mail"));
	    client.setPassword(request.getParameter("password"));
	    client.setPasswordConfirmation(request.getParameter("password-confirmation"));

	    return client;
	}

    @Override
    public ModelAndView setView(Result result, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("home"); // nome do HTML

        if (result.isSuccess()) {
            mv.addObject("mensagem", "Funcionário cadastrado com sucesso!");
            mv.addObject("cliente", result.getEntities().get(0));
        } else {
            mv.addObject("mensagem", result.getMessage());
        }

        return mv;
    }


}
