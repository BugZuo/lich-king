<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
<@block name="title">
    <title>Lich King</title>
</@block>

<@block name="metaInfo">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
</@block>

<@block name="baseCss">
    <link id="callCss" rel="stylesheet" href="../css/base/bootstrap.min.css" type="text/css"
          media="screen" charset="utf-8"/>

    <link id="callCss" rel="stylesheet" href="../css/base/style.css" type="text/css" media="screen"
          charset="utf-8"/>
</@block>
</head>

<body>
<@block name="headerSetion">
<div id="headerSection">
    <div class="container">
        <div class="span3 logo"><a href="#"><img src="../img/base/logo1.png" alt=""/></a></div>

        <div class="navbar">


            <div class="nav-collapse">
                <ul class="nav mynav">
                    <li><a href="#ourServices">What we do?</a></li>
                    <li><a href="#portfolioSection">Portfolio</a></li>
                    <li><a href="#meetourteamSection">Team</a></li>
                    <li><a href="#recentpostSection">Blog</a></li>
                    <li><a href="#contactSection">Support</a></li>
                </ul>
            </div>

            <button type="button" class="btn btn-navbar" data-toggle="collapse"
                    data-target=".nav-collapse">
                <span class="line"></span>
                <span class="line"></span>
                <span class="line"></span>
            </button>
        </div>
    </div>
</div>
</@block>
<!--Header Ends================================================ -->

<@block name="carouselSection">
<div id="carouselSection" class="cntr">
    <div id="myCarousel" class="carousel slide">

        <div class="carousel-inner">
            <div class="item active">
                <a class="cntr" href="#"><img src="/img/base/1.png" alt=""></a>
            </div>

            <div class="item">
                <a class="cntr" href="#"><img src="/img/base/1.png" alt=""></a>
            </div>


        </div>
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
</div>
</@block>

<!-- Sectionone block ends======================================== -->

<!-- Our Services======================================== -->
<@block name="ourServices">
<div id="ourServices">
    <div class="container">
        <div class="row">

            <div class="col-md-4 col-xs-12">

                <div class="info-img">
                    <img src="/img/base/img-1.png"></div>
                <h4>Flat Design</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris
                    faucibus tellus ac auctor posuere. </p>
            </div>
            <div class="col-md-4 col-xs-12">
                <div class="info-img"><img src="/img/base/img-2.png"></div>
                <h4>Great Ideas</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris
                    faucibus tellus ac auctor posuere. </p>
            </div>
            <div class="col-md-4 col-xs-12">
                <div class="info-img"><img src="/img/base/img-3.png"></div>
                <h4>Browser Compatibility</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris
                    faucibus tellus ac auctor posuere. </p>
            </div>
        </div>
    </div>
</div>
</@block>

<!-- Our Portfolio======================================== -->
<@block name="portfolioSection">
<div id="portfolioSection">
    <div class="col-xs-12"><h1 class="cntr">Portfolio</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris faucibus
            tellus ac auctor posuere. </p></div>
    <div class="container">
        <ul class="nav nav-pills pics-ul">
            <li class="active"><a href="#all" data-toggle="tab">ALL</a></li>
            <li><a href="#web" data-toggle="tab">WEB</a></li>
            <li><a href="#mobile" data-toggle="tab">MOBILE</a></li>
            <li><a href="#photo" data-toggle="tab">PHOTOGRAPHY</a></li>

        </ul>
        <div class="clr"></div>
        <div class="tabbable tabs">
            <div class="tab-content label-primary">

                <div class="tab-pane active" id="all">
                    <ul class="thumbnails">

                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#myModal1" role="button" data-toggle="modal"><img
                                            src="/img/base/img-4.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-5.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-6.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-7.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-8.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-9.png" alt=""></a>
                                </div>
                            </div>
                        </li>


                    </ul>

                </div>

                <div class="tab-pane" id="web">
                    <ul class="thumbnails">

                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#myModal1" role="button" data-toggle="modal"><img
                                            src="/img/base/img-5.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-4.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-6.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-7.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-8.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-9.png" alt=""></a>
                                </div>
                            </div>
                        </li>


                    </ul>

                </div>

                <div class="tab-pane" id="mobile">
                    <ul class="thumbnails">

                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#myModal1" role="button" data-toggle="modal"><img
                                            src="/img/base/img-5.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-6.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-4.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-7.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-8.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-9.png" alt=""></a>
                                </div>
                            </div>
                        </li>


                    </ul>

                </div>

                <div class="tab-pane" id="photo">
                    <ul class="thumbnails">

                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#myModal1" role="button" data-toggle="modal"><img
                                            src="/img/base/img-7.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-4.png" alt=""></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-md-4 col-xs-6">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-6.png" alt=""></a>
                                </div>
                            </div>
                        </li>


                    </ul>

                </div>


                <a href="#" class="btn btn-large btn-1">SHOW MORE</a>


            </div>
        </div>
    </div>
</div>
</@block>

<!-- Blog Section -->
<@block name="blogSection">
<div id="blogSection">

    <div class="container">

        <div class="row">


            <div class="col-lg-8 col-md-12">

                <div class="inner">
                    <h1>Layered Neatly Photoshop Template</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est.
                        Mauris faucibus tellus ac auctor posuere. Integer lobortis purus a felis
                        adipiscing, eget ornare justo semper. Etiam commodo tincidunt ante.</p>

                    <a href="#" class="btn btn-large btn-primary">SHOW MORE</a>
                </div>

            </div>

            <div class="col-lg-4 col-md-12">
                <img class="r-image" src="/img/base/img-10.png" alt=""/>
            </div>

        </div>

        <hr class="soften clear"/>

        <div class="row">

            <div class="col-lg-4 col-md-12">
                <img class="r-image" src="/img/base/img-10.png" alt=""/>
            </div>

            <div class="col-lg-8 col-md-12">

                <div class="inner">
                    <h1>Layered Neatly Photoshop Template</h1>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est.
                        Mauris faucibus tellus ac auctor posuere. Integer lobortis purus a felis
                        adipiscing, eget ornare justo semper. Etiam commodo tincidunt ante.</p>

                    <a href="#" class="btn btn-large btn-primary">SHOW MORE</a>
                </div>

            </div>


        </div>


    </div>
</div>
</@block>

<!-- Meet our team======================================== -->
<@block name="meetourteamSection">
<div id="meetourteamSection">
    <div class="col-xs-12"><h1 class="cntr">MEET OUR TEAM</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris faucibus
            tellus ac auctor posuere. </p></div>
    <div class="container">

        <div class="tabbable tabs">
            <div class="tab-content label-primary">

                <div class="tab-pane active" id="all">
                    <ul class="thumbnails">

                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-11.png" alt=""></a>
                                    <h4>JOHN SMITH</h4>
                                    <h5>Creative Director</h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>
                                    <a class="facebook" href="#"></a>
                                    <a class="twitter" href="#"></a>
                                    <a class="pin" href="#"></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-11.png" alt=""></a>
                                    <h4>JOHN SMITH</h4>
                                    <h5>Creative Director</h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>
                                    <a class="facebook" href="#"></a>
                                    <a class="twitter" href="#"></a>
                                    <a class="pin" href="#"></a>
                                </div>
                            </div>
                        </li>
                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-11.png" alt=""></a>
                                    <h4>JOHN SMITH</h4>
                                    <h5>Creative Director</h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>
                                    <a class="facebook" href="#"></a>
                                    <a class="twitter" href="#"></a>
                                    <a class="pin" href="#"></a>
                                </div>
                            </div>
                        </li>


                    </ul>


                </div>


            </div>
        </div>
    </div>
</div>
</@block>

<!-- recent post======================================== -->
<@block name="recentpostSection">
<div id="recentpostSection">
    <div class="col-xs-12"><h1 class="cntr">RECENT POST</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris faucibus
            tellus ac auctor posuere. </p></div>
    <div class="container">

        <div class="tabbable tabs">
            <div class="tab-content label-primary">

                <div class="tab-pane active" id="all">
                    <ul class="thumbnails">

                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-12.png" alt=""></a>
                                    <h4>Really Interesting Post</h4>
                                    <h6>October 27</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>

                                </div>
                            </div>
                        </li>
                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-12.png" alt=""></a>
                                    <h4>Really Interesting Post</h4>
                                    <h6>October 27</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>

                                </div>
                            </div>
                        </li>
                        <li class="col-sm-4 col-xs-12">
                            <div class="thumbnail">
                                <div class="blockDtl">
                                    <a href="#"><img src="/img/base/img-12.png" alt=""></a>
                                    <h4>Really Interesting Post</h4>
                                    <h6>October 27</h6>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
                                        et quam est. </p>

                                </div>
                            </div>
                        </li>


                    </ul>
                    <a href="#" class="btn btn-large btn-primary"
                       style="color: #a2a3a3;background-color: #fff;">SHOW MORE</a>

                </div>


            </div>
        </div>
    </div>
</div>
</@block>

<!-- Contact Section -->
<@block name="contactSection">
<div id="contactSection">
    <div class="col-xs-12"><h1 class="cntr">Contact Us</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et quam est. Mauris faucibus
            tellus ac auctor posuere. </p></div>
    <div class="container">
        <div class="row form-cover">
            <div class="col-xs-12 ">

                <form class="form-horizontal">
                    <fieldset>
                        <div class="control-group">

                            <div class="controls">
                                <input type="text" class="input-xlarge" id="input01">

                            </div>
                        </div>
                        <div class="control-group">

                            <div class="controls">
                                <input type="text" class="input-xlarge" id="input11">

                            </div>
                        </div>
                        <div class="control-group">

                            <div class="controls">
                                <textarea class="input-xlarge" id="textarea" rows="3"
                                          style="height:210px"></textarea>
                            </div>
                        </div>


                        <button type="submit" class="btn btn-large btn-primary"
                                style="color: #a2a3a3;background-color: #fff;margin-top:30px;">Send
                            Message
                        </button>

                    </fieldset>
                </form>
            </div>


        </div>
    </div>

    <div class="footerSection container">


        <div class=" col-sm-6 socialicon">
            <a class="facebook" href="http://www.facebook.com/xtendify"></a>
            <a class="twitter" href="http://www.twitter.com/xtendify"></a>
            <a class="html5" href="#"></a>
            <a class="icon2" href="#"></a>
        </div>


        <div class="copyright"><p> Copyright 2014 | Developed By <a
                href="http://www.tb3.co.in">tB3</a></p></div>
        <!--To remove this copyright notice, please donate via Xtendify at - https://www.xtendify.com/en/product/103-colorful-flat-bootstrap-theme. It will support the development process -->

    </div>


</div>
</@block>
<!-- Wrapper end -->


<a href="#" class="go-top"><i class="glyphicon glyphicon-arrow-up"></i></a>

<@block name="baseJs">
<script src="/js/base/jquery-1.9.1.min.js"></script>
<script src="/js/base/bootstrap.min.js" type="text/javascript"></script>
<script src="/js/base/jquery.scrollTo-1.4.3.1-min.js" type="text/javascript"></script>
<script src="/js/base/jquery.easing-1.3.min.js"></script>
<script src="/js/base/default.js"></script>
</@block>

<@block name="pageJs">
<script type="text/javascript">

    $(document).ready(function () {
        $('#myCarousel').carousel({
                                      interval: 7000
                                  });

    });


</script>
</@block>

</body>
</html>
