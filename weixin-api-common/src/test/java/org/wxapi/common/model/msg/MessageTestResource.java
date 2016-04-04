package org.wxapi.common.model.msg;

import org.apache.commons.lang3.StringUtils;

public class MessageTestResource {

    protected final String eventClick = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[FromUser]]></FromUserName>",
            "<CreateTime>123456789</CreateTime>", "<MsgType><![CDATA[event]]></MsgType>", "<Event><![CDATA[CLICK]]></Event>", "<EventKey><![CDATA[EVENTKEY]]></EventKey>", "</xml>");

    protected final String eventLocation = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>123456789</CreateTime>", "<MsgType><![CDATA[event]]></MsgType>", "<Event><![CDATA[LOCATION]]></Event>", "<Latitude>23.137466</Latitude>", "<Longitude>113.352425</Longitude>",
            "<Precision>119.385040</Precision>", "</xml>");

    protected final String eventScan = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[FromUser]]></FromUserName>",
            "<CreateTime>123456789</CreateTime>", "<MsgType><![CDATA[event]]></MsgType>", "<Event><![CDATA[SCAN]]></Event>", "<EventKey><![CDATA[SCENE_VALUE]]></EventKey>",
            "<Ticket><![CDATA[TICKET]]></Ticket>", "</xml>");

    protected final String eventSubscribe = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[FromUser]]></FromUserName>",
            "<CreateTime>123456789</CreateTime>", "<MsgType><![CDATA[event]]></MsgType>", "<Event><![CDATA[subscribe]]></Event>", "</xml>");

    protected final String eventView = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[FromUser]]></FromUserName>",
            "<CreateTime>123456789</CreateTime>", "<MsgType><![CDATA[event]]></MsgType>", "<Event><![CDATA[VIEW]]></Event>", "<EventKey><![CDATA[www.qq.com]]></EventKey>", "</xml>");

    protected final String normalImage = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[this is a url]]></PicUrl><MediaId><![CDATA[media_id]]></MediaId><MsgId>1234567890123456</MsgId></xml>";

    protected final String normalLink = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>1351776360</CreateTime>", "<MsgType><![CDATA[link]]></MsgType>", "<Title><![CDATA[公众平台官网链接]]></Title>", "<Description><![CDATA[公众平台官网链接]]></Description>",
            "<Url><![CDATA[url]]></Url>", "<MsgId>1234567890123456</MsgId>", "</xml>");

    protected final String normalLocation = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>1351776360</CreateTime>", "<MsgType><![CDATA[location]]></MsgType>", "<Location_X>23.134521</Location_X>", "<Location_Y>113.358803</Location_Y>", "<Scale>20</Scale>",
            "<Label><![CDATA[位置信息]]></Label>", "<MsgId>1234567890123456</MsgId>", "</xml>");

    protected final String replyImage = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[image]]></MsgType>", "<Image>", "<MediaId><![CDATA[media_id]]></MediaId>", "</Image>", "</xml>");

    protected final String replyMusic = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[music]]></MsgType>", "<Music>", "<Title><![CDATA[TITLE]]></Title>", "<Description><![CDATA[DESCRIPTION]]></Description>",
            "<MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>", "<HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>", "<ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>", "</Music>", "</xml>");

    protected final String replyNews = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[news]]></MsgType>", "<ArticleCount>2</ArticleCount>", "<Articles>", "<item>", "<Title><![CDATA[title1]]></Title> ",
            "<Description><![CDATA[description1]]></Description>", "<PicUrl><![CDATA[picurl]]></PicUrl>", "<Url><![CDATA[url]]></Url>", "</item>", "<item>", "<Title><![CDATA[title]]></Title>",
            "<Description><![CDATA[description]]></Description>", "<PicUrl><![CDATA[picurl]]></PicUrl>", "<Url><![CDATA[url]]></Url>", "</item>", "</Articles>", "</xml>");

    protected final String replyText = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[text]]></MsgType>", "<Content><![CDATA[你好]]></Content>", "</xml>");

    protected final String replyVideo = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[video]]></MsgType>", "<Video>", "<MediaId><![CDATA[media_id]]></MediaId>", "<Title><![CDATA[title]]></Title>",
            "<Description><![CDATA[description]]></Description>", "</Video> ", "</xml>");

    protected final String replyVoice = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>12345678</CreateTime>", "<MsgType><![CDATA[voice]]></MsgType>", "<Voice>", "<MediaId><![CDATA[media_id]]></MediaId>", "</Voice>", "</xml>");

    protected final String normalShortvideo = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>1357290913</CreateTime>", "<MsgType><![CDATA[shortvideo]]></MsgType>", "<MediaId><![CDATA[media_id]]></MediaId>", "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>",
            "<MsgId>1234567890123456</MsgId>", "</xml>");

    protected final String normalText = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";

    protected final String normalVideo = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>1357290913</CreateTime>", "<MsgType><![CDATA[video]]></MsgType>", "<MediaId><![CDATA[media_id]]></MediaId>", "<ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId>",
            "<MsgId>1234567890123456</MsgId>", "</xml>");

    protected final String normalVoice = StringUtils.join("<xml>", "<ToUserName><![CDATA[toUser]]></ToUserName>", "<FromUserName><![CDATA[fromUser]]></FromUserName>",
            "<CreateTime>1357290913</CreateTime>", "<MsgType><![CDATA[voice]]></MsgType>", "<MediaId><![CDATA[media_id]]></MediaId>", "<Format><![CDATA[Format]]></Format>",
            "<MsgId>1234567890123456</MsgId>", "</xml>");

}
