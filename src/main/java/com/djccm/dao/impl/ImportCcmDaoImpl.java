package com.djccm.dao.impl;

import com.djccm.dao.ImportCcmDao;
import com.djccm.entity.CcRechargeHistory;
import com.djccm.entity.InsertModel;
import com.djccm.entity.PlatformAuthentiCation;
import com.seeyon.framework.dao.common.BaseDaoImpl;
import com.seeyon.framework.exception.BaseException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
@Repository("importCcmDao")
public class ImportCcmDaoImpl extends BaseDaoImpl implements ImportCcmDao {
    @Override
    public PlatformAuthentiCation selectPlatformAuthentiCation(PlatformAuthentiCation platformAuthentiCation) throws BaseException {
        return (PlatformAuthentiCation) this.findByID("getPlatformAuthentiCation",platformAuthentiCation);
    }

    @Override
    public List<CcRechargeHistory> getCcinfo() throws BaseException {
        return  this.findByParam("getCcinfo",null);
    }

    @Override
    public boolean insertCcrechargeInfo(InsertModel insertModel) throws BaseException{
        boolean flag = true;
        try {
            this.insert("insertCcrechargeInfo",insertModel);
            this.insert("insertCcRechargeHistory", insertModel);
        } catch (Exception e) {
            flag = false;
            throw new BaseException("updateFirstRental error", e);
        }
        return flag;
    }

   /* @Override
    public boolean insertCcRechargeHistory(CcRechargeHistory ccRechargeHistory) throws BaseException {
        boolean flag = true;
        try {
            this.insert("insertCcRechargeHistory", ccRechargeHistory);
        } catch (Exception e) {
            flag = false;
            throw new BaseException("updateFirstRental error", e);
        }
        return flag;
    }*/
}
