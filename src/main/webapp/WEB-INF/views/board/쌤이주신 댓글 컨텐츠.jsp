<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
   <meta charset="UTF-8">
   <title>Insert title here</title>

   <%@ include file="../include/static-head.jsp" %>

   <style>
      footer {
         border-top: 1px solid gray;
         padding: 30px;
         width: 100%;
         height: 150px;
         position: absolute;
         bottom: 0;
      }
   </style>

</head>

<body>
   <div class="container">
      <div class="row">
         <div class="offset-md-1 col-md-10">
            <h1>${article.boardNo}번 게시물 내용</h1>

            <p>
               # 글번호: ${article.boardNo}<br>
               # 작성자: ${article.writer}<br>
               # 제목: ${article.title}<br>
               # 내용: <br>
               <textarea rows="5" cols="30" disabled>${article.content}</textarea>
            </p>

            <a href="/board/list?page=${cri.page}&type=${cri.type}&keyword=${cri.keyword}&amount=${cri.amount}">글
               목록보기</a>&nbsp;
            <a href="/board/modify?boardNo=${article.boardNo}&vf=false">글 수정하기</a>
         </div>
      </div>

      <!-- 댓글 영역 -->

      <div id="replies" class="row">
         <div class="offset-md-1 col-md-10">
            <!-- 댓글 쓰기 영역 -->
            <div class="card">
               <div class="card-body">
                  <div class="row">
                     <div class="col-md-9">
                        <div class="form-group">
                           <label for="newReplyText" hidden>댓글 내용</label>
                           <textarea rows="3" id="newReplyText" name="replyText" class="form-control"
                              placeholder="댓글을 입력해주세요."></textarea>
                        </div>
                     </div>
                     <div class="col-md-3">
                        <div class="form-group">
                           <label for="newReplyWriter" hidden>댓글 작성자</label>
                           <input id="newReplyWriter" name="replyWriter" type="text" class="form-control"
                              placeholder="작성자 이름" style="margin-bottom: 6px;">
                           <button id="replyAddBtn" type="button" class="btn btn-dark form-control">등록</button>
                        </div>
                     </div>
                  </div>
               </div>
            </div> <!-- end reply write -->

            <!--댓글 내용 영역-->
            <div class="card">
               <!-- 댓글 내용 헤더 -->
               <div class="card-header text-white m-0" style="background: #343A40;">
                  <div class="float-left">댓글 (<span id="replyCnt">0</span>)</div>
               </div>

               <!-- 댓글 내용 바디 -->
               <div id="replyCollapse" class="card-collapse collapse">
                  <div id="replyData">
                     <!-- 
                        < JS로 댓글 정보 DIV삽입 > 
                     -->
                  </div>

                  <!-- 댓글 페이징 영역 -->
                  <ul class="pagination justify-content-center">
                     <!-- 
                        < JS로 댓글 페이징 DIV삽입 > 
                     -->
                  </ul>
               </div>
            </div> <!-- end reply content -->
         </div>
      </div> <!-- end replies row -->
   </div> <!-- end content container -->

   <!-- 댓글 수정 모달 -->
   <div class="modal fade bd-example-modal-lg" id="replyModifyModal">
      <div class="modal-dialog modal-lg">
         <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header" style="background: #343A40; color: white;">
               <h4 class="modal-title">댓글 수정하기</h4>
               <button type="button" class="close text-white" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
               <div class="form-group">
                  <input id="modReplyId" type="hidden">
                  <label for="modReplyText" hidden>댓글내용</label>
                  <textarea id="modReplyText" class="form-control" placeholder="수정할 댓글 내용을 입력하세요." rows="3"></textarea>
               </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
               <button id="replyModBtn" type="button" class="btn btn-dark">수정</button>
               <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
            </div>


         </div>
      </div>
   </div>

   <!-- end replyModifyModal -->


   <%@ include file="../include/footer.jsp" %>

</body>

</html>