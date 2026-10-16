# 실제 프로젝트의 부분 코드 예제

`src/com/filmmeter/app/IsoEiSettings.java`와 `FrameFormats.java`는 앱 0.2.7에서 **수정 없이 복사한 실제 파일**입니다. 앱의 측광·보정·카메라 구현을 포함하지 않는 독립 상태 유틸리티입니다.

`demo/com/filmmeter/app/ExampleRunner.java`와 `run.sh`는 공개 자료를 위해 새로 작성한 실행 도구입니다. 앱 원본 구현이라고 소개하지 않으며, 생략된 기능을 가짜로 대체하지 않습니다.

## 실행

JDK 17 이상과 POSIX 셸이 있는 환경에서 공개 자료의 루트에서 실행합니다.

```sh
sh examples/run.sh
```

원본 두 클래스와 콘솔 실행기만 임시 디렉터리에 컴파일하고, ISO/EI 연동과 프레임 순환을 확인한 뒤 임시 결과를 제거합니다. Android SDK·Gradle·서명 정보는 사용하지 않습니다. Windows 자체 셸에서의 실행은 검증하지 않았습니다.

이 명령으로 생기는 것은 Java 콘솔 예제 실행 결과뿐입니다. Android 앱, 카메라 미리보기, 측정값, 프로파일 저장, APK나 AAB는 생성하지 않습니다.

예제 공개와 라이선스 허락은 별개입니다. [이용 조건 제안](../TERMS-PROPOSAL.md)은 아직 채택되지 않았습니다.
