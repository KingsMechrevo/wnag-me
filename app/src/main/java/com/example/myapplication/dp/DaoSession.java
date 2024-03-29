package com.example.myapplication.dp;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.myapplication.bean.CollectBean;

import com.example.myapplication.dp.CollectBeanDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig collectBeanDaoConfig;

    private final CollectBeanDao collectBeanDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        collectBeanDaoConfig = daoConfigMap.get(CollectBeanDao.class).clone();
        collectBeanDaoConfig.initIdentityScope(type);

        collectBeanDao = new CollectBeanDao(collectBeanDaoConfig, this);

        registerDao(CollectBean.class, collectBeanDao);
    }
    
    public void clear() {
        collectBeanDaoConfig.clearIdentityScope();
    }

    public CollectBeanDao getCollectBeanDao() {
        return collectBeanDao;
    }

}
