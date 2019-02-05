package com.yzq.bbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzq.bbs.mapper.ReplyMapper;
import com.yzq.bbs.pojo.Reply;
import com.yzq.bbs.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    public ReplyMapper replyDao;

    public List<Reply> getRepliesOfTopic(Integer topicId) {
        return replyDao.getRepliesOfTopic(topicId);
    }

    public boolean addReply(Reply reply) {
        return replyDao.insert(reply)>0;
    }

    public int repliesNum(Integer topicId) {
        return replyDao.getRepliesNum(topicId);
    }
}
