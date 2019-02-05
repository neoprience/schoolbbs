package com.yzq.bbs.service;


import java.util.List;

import com.yzq.bbs.pojo.Reply;

public interface ReplyService {

    List<Reply> getRepliesOfTopic(Integer topicId);

    boolean addReply(Reply reply);

    int repliesNum(Integer topicId);
}
