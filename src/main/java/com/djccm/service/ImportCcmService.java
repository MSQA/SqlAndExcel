package com.djccm.service;

import com.djccm.entity.CcRechargeHistory;
import com.djccm.entity.InsertModel;
import com.djccm.entity.PlatformAuthentiCation;
import com.seeyon.framework.exception.BaseException;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30 0030.
 */
public interface ImportCcmService {
    public PlatformAuthentiCation selectPlatformAuthentiCation(PlatformAuthentiCation platformAuthentiCation) throws BaseException;

    public boolean insertCcrechargeInfo(InsertModel insertModel) throws BaseException;

    public List<CcRechargeHistory> getCcinfo() throws BaseException;
   /* public boolean insertCcRechargeHistory(CcRechargeHistory ccRechargeHistory) throws BaseException;*/
}
