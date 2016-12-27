package com.djccm.service.impl;

import com.djccm.dao.ImportCcmDao;
import com.djccm.entity.CcRechargeHistory;
import com.djccm.entity.InsertModel;
import com.djccm.entity.PlatformAuthentiCation;
import com.djccm.service.ImportCcmService;
import com.seeyon.framework.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
@Service("importCcmService")
public class ImportCcmServiceImpl implements ImportCcmService {
    @Autowired
    private ImportCcmDao importCcmDao;

    @Override
    public PlatformAuthentiCation selectPlatformAuthentiCation(PlatformAuthentiCation platformAuthentiCation) throws BaseException {
        return importCcmDao.selectPlatformAuthentiCation(platformAuthentiCation);
    }

    @Override
    public List<CcRechargeHistory> getCcinfo() throws BaseException {
        return importCcmDao.getCcinfo();
    }

    @Override
    public boolean insertCcrechargeInfo(InsertModel insertModel) throws BaseException {

        insertModel.setPaystatus(2);
        insertModel.setCashbalance(100.00);
        insertModel.setPresentbalance(0.00);
        insertModel.setTotalbalance(100.00);
        insertModel.setCompanyid("681647195274184468482722");//681647195274184468482722
        insertModel.setOrderno("手工调整,余额清零");
        insertModel.setPaytype(1001);//8001
        insertModel.setType(2);
        insertModel.setRechargeamount(100.00);
        insertModel.setPresentamount(0.00);
        return importCcmDao.insertCcrechargeInfo(insertModel);
    }

   /* @Override
    public boolean insertCcRechargeHistory(CcRechargeHistory ccRechargeHistory) throws BaseException {
        return importCcmDao.insertCcRechargeHistory(ccRechargeHistory);
    }*/
}
