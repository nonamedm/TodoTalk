<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal-wrap" id="translation-wrap">
            <div class="modal-bg"></div>
            <div class="modal-container">
                <div class="modal-header">
                    <h4>번역기</h4>
                </div>
                <div class="modal-contents">
                	<div class="select-language">
                		<div>
                			<select class="languages-box">
                				<option value="ko" selected="selected">한국어</option>
                				<option value="en">영어</option>
                				<option value="ja">일본어</option>
                				<option value="zh-CN">중국어 간체</option>
                				<option value="zh-TW">중국어 번체</option>
                				<option value="vi">베트남어</option>
                				<option value="id">인도네시아어</option>
                				<option value="th">태국어</option>
                				<option value="de">독일어</option>
                				<option value="ru">러시아어</option>
                				<option value="es">스페인어</option>
                				<option value="it">이탈리아어</option>
                				<option value="fr">프랑스어</option>
                			</select>
                			<textarea id="getText" class="translation-Text"></textarea>
                		</div>
                		<div>
	                		<a href="javascript:translationSend()" class="translation-btn">번역하기</a>
                		</div>
                		<div>
                			<select class="languages-box2">
                				<option value="ko">한국어</option>
                				<option value="en" selected="selected">영어</option>
                				<option value="ja">일본어</option>
                				<option value="zh-CN">중국어 간체</option>
                				<option value="zh-TW">중국어 번체</option>
                				<option value="vi">베트남어</option>
                				<option value="id">인도네시아어</option>
                				<option value="th">태국어</option>
                				<option value="de">독일어</option>
                				<option value="ru">러시아어</option>
                				<option value="es">스페인어</option>
                				<option value="it">이탈리아어</option>
                				<option value="fr">프랑스어</option>
                			</select>
                			<textarea class="translation-Text" id="tarText" readonly="readonly"></textarea>
                		</div>
                	</div>
                    <div class="modal-btn-box">
                        <ul>
                            <li>
                                <a href="#" title="취소" class="btn-cancel" id="btn-cancel">닫기</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div> <!-- //modal-picture-->
<!-- <div id="" style="display: none;"> -->
<!--     <input type="text" id="getText" /> -->
<!-- 	<a href="#" id="btn">번역하기</a> -->
<!-- 	<div id="div"></div> -->
</div>