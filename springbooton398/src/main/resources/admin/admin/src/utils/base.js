const base = {
    get() {
        return {
            url : "http://localhost:8080/springbooton398/",
            name: "springbooton398",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbooton398/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "原创歌曲分享平台"
        } 
    }
}
export default base
