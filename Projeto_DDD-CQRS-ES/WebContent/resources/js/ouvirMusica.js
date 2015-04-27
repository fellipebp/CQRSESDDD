jQuery(document).ready(function( $ ) {
});

function tocarMusica(nomeMusica){
	jQuery("#jquery_jplayer_1").jPlayer({
		ready : function() {
			jQuery(this).jPlayer("setMedia", {
				title : "Musica",
				mp3 : "/Projeto_DDD-CQRS-ES/resources/music/"+nomeMusica
			});
		},
		cssSelectorAncestor : "#jp_container_1",
		swfPath : "/js",
		supplied : "mp3",
		useStateClassSkin : true,
		autoBlur : false,
		smoothPlayBar : true,
		keyEnabled : true,
		remainingDuration : true,
		toggleDuration : true
	});
}

