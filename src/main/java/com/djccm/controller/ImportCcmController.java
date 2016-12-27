package com.djccm.controller;

import com.djccm.entity.InsertModel;
import com.djccm.entity.PlatformAuthentiCation;
import com.djccm.service.ImportCcmService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
@Controller
@RequestMapping(value = "ccm/importccm")
public class ImportCcmController{
    @Autowired(required = false)
    private ImportCcmService importCcmService;


    @RequestMapping(value = "/leadingIn")
    @ResponseBody
    public ModelAndView leadingIn(HttpServletRequest request, HttpServletResponse response) throws BaseException {
        ModelAndView modelAndView = new ModelAndView();
        String userName=request.getParameter("userName");
        String name=request.getParameter("name");
        PlatformAuthentiCation platformAuthentiCation=new PlatformAuthentiCation();
        platformAuthentiCation.setUserName(userName);
        PlatformAuthentiCation p=importCcmService.selectPlatformAuthentiCation(platformAuthentiCation);
        InsertModel insertModel=new InsertModel();
        insertModel.setUserid(p.getPersonID());
        insertModel.setName(name);
        insertModel.setPaystatus(1);
        insertModel.setCashbalance(0.00);
        insertModel.setPresentbalance(0.00);
        insertModel.setTotalbalance(0.00);
        insertModel.setCompanyid("892485852779041661174379");
        UUID defid=UUID.randomUUID();
        insertModel.setDefid(defid.toString());
        UUID rechargid=UUID.randomUUID();
        insertModel.setRechargeid(rechargid.toString());
        UUID historyid=UUID.randomUUID();
        insertModel.setHistoryid(historyid.toString());
        UUID orderid=UUID.randomUUID();
        insertModel.setOrderid(orderid.toString());
        UUID orderno=UUID.randomUUID();
        insertModel.setOrderno(orderno.toString());
        insertModel.setType(1);
        insertModel.setRechargeamount(100.00);
        insertModel.setPresentamount(0.00);
        if(name.matches("^(13|15|18)\\d{9}$")) {
            insertModel.setMobilephone(name);
        }
        return modelAndView;
    }
}
