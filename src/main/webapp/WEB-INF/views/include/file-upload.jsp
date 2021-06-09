<script>
    $(function () { // start jQuery

        // drag & drop 이벤트
        const $dropBox = $('.fileDrop');

        // 드래그 진입 이벤트
        $dropBox.on('dragover dragenter', e => {
            e.preventDefault();
            $dropBox.css('border-color', 'red')
                .css('background', 'lightgray');
        });

        // 드래그 탈출 이벤트
        $dropBox.on('dragleave', e => {
            e.preventDefault();
            $dropBox.css('border-color', 'gray')
                .css('background', 'transparent');
        });

        // 드롭 이벤트
        $dropBox.on('drop', e => {
            e.preventDefault();
            //alert('파일이 드롭됨!');

            // 1. 드롭 된 파일의 데이터 읽기
            const fileDatas = e.originalEvent.dataTransfer.files;
            // console.log('fileDatas: ', fileDatas);

            // 2. 읽은 파일 데이터 input 태그에 저장
            const $fileInput = $('#ajax-file');
            $fileInput.prop('files', fileDatas);

            // 3. 담은 데이터를 서버로 전송
            // - 비동기로 파일을 보내려면 FormData 객체가 필요함!
            const formData = new FormData();
            // console.log('input: ', $fileInput);

            const sendFileList = $fileInput[0].files;
            // 서버로 전송할 파일들을 formData 에 담아 비동기 요청
            for (let file of sendFileList) {
                formData.append('files', file);
            }

            // 4. 업로드 비동기 요청
            const reqInfo = {
                method: 'POST',
                body: formData
            };
            fetch('/upload-ajax', reqInfo)
                .then(res => res.json())
                .then(pathList => {
                    console.log(pathList);
                    showFileData(pathList);
                });
        });

        // 드롭한 파일의 형식에 따라 태그를 만들어주는 함수
        function showFileData(pathList) {
            // 경로: \2021\06\08\adsfadsf_asdfasdf_dog.gif
            for (let path of pathList) {
                // 이미지인지 아닌지에 따라 구분하여 처리
                checkExtType(path);
            }
        }


        // 확장자 판별 후 태그 생성 처리 함수
        function checkExtType(path) {
            // 원본 파일명 추출
            let originFileName = path.substring(path.indexOf("_") + 1);

            const $div = document.createElement('div');
            $div.classList.add('thumbnail-box');

            const $delBtn = document.createElement('a');
            $delBtn.classList.add('del-btn');
            $delBtn.setAttribute('href', path);
            $delBtn.textContent = 'X';

            // 게시글 첨부파일 등록을 위한 input:hidden 추가
            const $input = document.createElement('input');
            $input.setAttribute('type', 'hidden');
            $input.setAttribute('name', 'filePathList');
            $input.setAttribute('value', path);

            $div.appendChild($input);

            // 이미지인지 확장자 체크
            if (isImageFile(originFileName)) {
                //이미지인 경우
                originFileName = originFileName.substring(originFileName.indexOf("_") + 1);

                const $img = document.createElement('img');
                $img.setAttribute('src', '/loadFile?fileName=' + path);
                $img.setAttribute('alt', originFileName);

                $div.appendChild($img);
                $div.appendChild($delBtn);
            } else {
                // 이미지가 아닌 경우: 다운로드 링크 생성
                const $link = document.createElement('a');
                $link.setAttribute('href', '/loadFile?fileName=' + path);
                $link.innerHTML = '<img src="/img/file_icon.jpg" alt="파일아이콘"> <span class="file-name">' +
                    originFileName + '</span>';

                $div.appendChild($link);
                $div.appendChild($delBtn);
            }
            $('.uploaded-list').append($div);
        }

        // 정규표현식으로 이미지 파일 여부 확인하는 함수
        function isImageFile(originFileName) {
            const pattern = /jpg$|gif$|png$/i;
            return originFileName.match(pattern);
        }

        // 파일 삭제 비동기 요청 클릭 이벤트
        $('.uploaded-list').on('click', '.del-btn', e => {

            e.preventDefault();
            console.log(e.target.getAttribute('href'));

            const path = e.target.getAttribute('href');

            const $uploadedList = document.querySelector('.uploaded-list');

            fetch('/deleteFile?fileName=' + path, {method: 'DELETE'})
            .then(res => res.text())
            .then(msg => {
                if (msg === 'fileDeleteSuccess') {
                    const $thumbBox = e.target.parentNode;
                    $uploadedList.removeChild($thumbBox);
                } else {
                    alert('파일 삭제 실패!');
                }
            });
        });



    }); // end jQuery
</script>