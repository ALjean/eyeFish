package com.jean.dao;

import java.sql.Date;
import java.util.List;

import com.jean.CustomDfmException;
import com.jean.DaoDfmException;
import com.jean.entity.Bait;
import com.jean.entity.Message;

public interface BaitDao {

    Bait getBait(int baitId) throws DaoDfmException;
    
    List<Bait> getBaits(int fishId) throws DaoDfmException;
    
    List<Bait> getBaits(int fishId, Date date) throws DaoDfmException;
    
    Integer saveBait(Bait bait) throws DaoDfmException, CustomDfmException;

    void deleteBait(int baitId) throws DaoDfmException, CustomDfmException;
    
    Integer updateBait(Bait bait) throws DaoDfmException;
    
    Message getMessage(String key) throws DaoDfmException;
    
    Message getMessage(int messageId);
    
    List<String> getMessages() throws DaoDfmException;
    
    Integer saveMessage(Message message);
    
    Integer updateMessage(Message mesage);
    
    void deleteMessage(int messageId);
 
}
